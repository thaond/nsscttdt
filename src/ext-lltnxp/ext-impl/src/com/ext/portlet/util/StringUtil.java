package com.ext.portlet.util;


public class StringUtil
{

    public StringUtil()
    {
    }

    public static String Split(String s, int limit)
    {
        String newstring = "";
        String words[] = s.split(" ");
        if(words.length > limit)
        {
            for(int i = 0; i < limit; i++)
            {
                newstring = (new StringBuilder(String.valueOf(newstring))).append(words[i]).toString();
                newstring = (new StringBuilder(String.valueOf(newstring))).append(" ").toString();
            }

            return newstring;
        } else
        {
            return s;
        }
    }

    public static String getFilename(String s)
    {
        String newString = "";
        String words[] = s.split("/");
        if(words.length > 0)
        {
            newString = words[words.length - 1];
            return newString;
        } else
        {
            return s;
        }
    }

	public static String encodeHtml(String recordname) {
		recordname = recordname.replaceAll("<", "&lt;");
		recordname = recordname.replaceAll(">", "&gt;");
		return recordname;
	}
}