package io.github.zephyrwolf.medievalism.tools;

public final class LangTools
{
    // e.g. "medievalism", "pack.title.user"
    public static String lang(final String modId, final String id)
    {
        return "%s.%s".formatted(modId, id);
    }
}
