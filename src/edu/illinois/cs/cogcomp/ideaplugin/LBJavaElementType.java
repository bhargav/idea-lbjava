package edu.illinois.cs.cogcomp.ideaplugin;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;

public class LBJavaElementType extends IElementType {
    private final IElementType parsedType;

    public LBJavaElementType(@NotNull @NonNls String debugName, IElementType parsedType) {
        super(debugName, LBJavaLanguage.INSTANCE);
        this.parsedType = parsedType;
    }

    public LBJavaElementType(@NotNull @NonNls String debugName) {
        this(debugName, null);
    }

    public IElementType getParsedType() {
        return parsedType != null ? parsedType : this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("LBJava:{0}", super.toString());
    }
}
