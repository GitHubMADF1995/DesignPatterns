package com.madf.asm;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static org.objectweb.asm.Opcodes.*;

public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/madf/asm/Tank.class"));

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                //return mv;
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/madf/asm/TimeProxy","before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

//        cr.accept(cw, 0);//使用这个代码，就是直接复制了一份原来的字节码文件
        cr.accept(cv, 0);//自动以ClassVisitor，修改源字节码文件
        byte[] b2 = cw.toByteArray();

        MyClassLoader cl = new MyClassLoader();
        //Class c = cl.loadClass("com.mashibing.dp.ASM.Tank");
        cl.loadClass("com.madf.asm.TimeProxy");
        Class c2 = cl.defineClass("com.madf.asm.Tank", b2);
        c2.getConstructor().newInstance();


        String path = (String)System.getProperties().get("user.dir");
        File f = new File(path + "/com/madf/asm/");
        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/madf/asm/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();

    }
}
