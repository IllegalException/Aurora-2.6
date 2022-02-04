//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package team.stiff.pomelo.impl.annotated.handler.scan;

import java.util.function.*;
import java.lang.reflect.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import java.lang.annotation.*;

public final class AnnotatedListenerPredicate implements Predicate<Method>
{
    @Override
    public boolean test(final Method method) {
        return method.isAnnotationPresent((Class<? extends Annotation>)Listener.class) && method.getParameterCount() == 1;
    }
}
