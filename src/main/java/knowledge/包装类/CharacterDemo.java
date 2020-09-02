package knowledge.包装类;

import org.junit.Test;

/**
 * Character
 * <p>
 * static boolean   isUpperCase(char ch / int codePoint)        确定指定字符（Unicode 代码点）是否为大写字母
 * static boolean   isLowerCase(char ch / int codePoint)        确定指定字符（Unicode 代码点）是否为小写字母
 * <p>
 * static boolean	isDefined(char ch / int codePoint)          确定字符（Unicode 代码点）是否被定义为 Unicode 中的字符
 * static boolean	isMirrored(char ch / int codePoint)         确定指定字符（Unicode 代码点）依据 Unicode 规范是否对称
 * <p>
 * static boolean	isDigit(char ch / int codePoint)            确定指定字符（Unicode 代码点）是否为数字
 * static boolean	isLetter(char ch / int codePoint)           确定指定字符（Unicode 代码点）是否为字母
 * static boolean	isLetterOrDigit(char ch / int codePoint)    确定指定字符（Unicode 代码点）是否为字母或数字
 * <p>
 * static boolean	isJavaIdentifierPart(char ch / int codePoint)确定字符（Unicode 代码点）是否可以是 Java 标识符中首字符以外的部分
 * static boolean	isJavaIdentifierStart(char ch / int codePoint)确定是否允许将字符（Unicode 代码点）作为 Java 标识符中的首字符
 * <p>
 * static char      toUpperCase(char ch / int codePoint)        使用取自 UnicodeData 文件的大小写映射信息将字符（Unicode 代码点）参数转换为大写
 * static char      toLowerCase(char ch / int codePoint)        使用取自 UnicodeData 文件的大小写映射信息将字符（Unicode 代码点）参数转换为小写
 */
public class CharacterDemo {

    /**
     * static int	codePointAt(char[] a, int index[, int limit])
     * 返回 char 数组的给定索引上的代码点，该数组中只有那些具有小于 limit 的 index 值的数组元素可以使用
     *
     * static int	codePointAt(CharSequence seq, int index)
     * 返回 CharSequence 的给定索引上的代码点
     *
     * static int	codePointBefore(char[] a, int index[, int start])
     * 返回 char 数组的给定索引前面的代码点，该数组中只有那些具有大于等于 start 的 index 值的数组元素可以使用
     *
     * static int	codePointBefore(CharSequence seq, int index)
     * 返回 CharSequence 的给定索引前面的代码点
     */
    @Test
    public void codePointXXX() {
        p(Character.codePointAt("abc", 0)); // 97
        p(Character.codePointAt("abc", 2)); // 99

        p(Character.codePointBefore("abc", 2)); // 98

    }


    /**
     * static boolean	isSpaceChar(char ch / int codePoint)
     * 确定指定字符（Unicode 代码点）是否为 Unicode 空白字符
     * 空白字符指 Unicode 空格字符（SPACE_SEPARATOR、LINE_SEPARATOR 或 PARAGRAPH_SEPARATOR)
     * <p>
     * static boolean   isWhitespace(char ch / int codePoint)       建议使用
     * 确定指定字符（Unicode 代码点）依据 Java 标准是否为空白字符
     * 同上，但不是非中断空格（'\u00A0'、'\u2007'、'\u202F'）
     * '\u0009' \t  HORIZONTAL TABULATION   水平制表符
     * '\u000A' \n  LINE FEED               换行
     * '\u000B'     VERTICAL TABULATION     纵向制表符
     * '\u000C' \f  FORM FEED               换页
     * '\u000D' \r  CARRIAGE RETURN         回车
     * '\u001C'     FILE SEPARATOR          文件分隔符
     * '\u001D'     GROUP SEPARATOR         组分隔符
     * '\u001E'     RECORD SEPARATOR        记录分隔符
     * '\u001F'     UNIT SEPARATOR          单元分隔符
     */
    @Test
    public void isSpace() {
        p(Character.isSpaceChar(' '));    // true
        p(Character.isSpaceChar('\f'));   // false，换页
        p(Character.isSpaceChar('\n'));   // false，换行
        p(Character.isSpaceChar('\r'));   // false，回车
        p(Character.isSpaceChar('\t'));   // false，tab
        
        p(Character.isWhitespace(' '));    // true
        p(Character.isWhitespace('\f'));   // true，换页
        p(Character.isWhitespace('\n'));   // true，换行
        p(Character.isWhitespace('\r'));   // true，回车
        p(Character.isWhitespace('\t'));   // true，tab
    }
    
    private static <T> void p(T obj) {
        if (obj == null) return;
        System.out.println(obj);
    }

}
