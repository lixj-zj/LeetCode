package string;

/**
 * @Description: 1108. IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * 示例 1：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * 示例 2：
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 * 提示：
 * 给出的 address 是一个有效的 IPv4 地址
 * --------------------------------------
 * @ClassName: DefangIPaddr_S_1108.java
 * @Date: 2021/5/17 17:06
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class DefangIPaddr_S_1108 {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr2(address));
    }

    /**
     * 简单的字符分割、追加
     * */
    public static String defangIPaddr(String address) {
        if (address.isEmpty()) {
            return null;
        }
        String[] strings = address.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]).append("[.]");
        }
        return stringBuffer.toString().substring(0,stringBuffer.toString().length() - 3);
    }

    /**
     * 简单的字符替换
     * */
    public static String defangIPaddr2(String address){
        return address.replace(".", "[.]");
    }

}
