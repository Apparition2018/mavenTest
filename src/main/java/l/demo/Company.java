package l.demo;

/**
 * Company
 * <p>
 * 往枚举中添加变量、构造函数、以达到灵活获取指定值的目的
 * 通常用于一些业务系统中定义一些固定值，如用于匹配db中的字段值等
 * <p>
 * Java 编译器会自动在 enum 中插入 一些方法，比如 values()：https://blog.csdn.net/u013469218/article/details/66476182
 *
 * @author ljh
 * created on 2020/11/2 14:04
 */
public enum Company {
    // 利用构造函数传参
    SF("顺丰速运", 1001),
    YTO("圆通速递", 1002),
    STO("申通物流", 1003),
    EMS("中国邮政", 1004),
    DHL("中外运敦豪", 1005);

    private String company;

    private int code;

    // 构造函数默认为私有
    Company(String company, int code) {
        this.company = company;
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 根据物流公司名字获取对应的编码
     */
    public static int getCodeByCompany(String company) {
        for (Company c : Company.values()) {
            if (c.getCompany().equals(company.trim())) {
                return c.code;
            }
        }
        return 0;
    }

    /**
     * 根据物流公司编码获取对应的名字
     */
    public static String getCompanyByCode(int code) {
        for (Company c : Company.values()) {
            if (c.getCode() == code) {
                return c.getCompany();
            }
        }
        return null;
    }

    /**
     * 遍历
     */
    public void traversal() {
        Company[] companies = Company.values();
        for (Company company : companies) {
            System.out.println("name: " + company.name());
            System.out.println("ordinal: " + company.ordinal());
            System.out.println("company: " + company);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "company='" + company + '\'' +
                ", code=" + code +
                '}';
    }
}
