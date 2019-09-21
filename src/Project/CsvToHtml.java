package Project;

public class CsvToHtml {

    //过滤一些特殊字符
    public static String filterChars(String lineIn) {
        //若考虑线程安全需将换StringBuilder成StringBuffer
        StringBuilder sb = new StringBuilder();
        int lineLength = lineIn.length();
        for (int i = 0; i < lineLength; i++) {
            char c = lineIn.charAt(i);
            switch (c) {
                case '"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
    //将数据加入表格
    public static void buildRow(StringBuilder sb, String[] columns) {
        sb.append("<tr>");
        for (int i = 0; i < columns.length; i++) {
            sb.append("<th>");
            sb.append(filterChars(columns[i]));
            sb.append("</th>");
        }
        sb.append("</tr>\n");
    }
    public static void main(String[] args) throws Exception {
        String csv =
                "角色,描述\n" +
                        "牛妹,牛客大网红，著有<牛客网发帖十大规范&&准则>\n" +
                        "牛牛,牛客小网红，长期出现在牛客编程题里，智商保持在1 + 1 = 3\n" +
                        "狗哥,牛客待嫁小青年";
        //把csv以换行符为分隔符存入lines
        String[] lines = csv.split("\n");
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<title>CSV2HTML</title>\n");
        sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n");
        sb.append("</head><body><h1>CSV2HTML</h1>\n");
        sb.append("<table>\n");
        for (String line : lines) {
            //把每一行以逗号为分隔符分开存入colums，然后将数据输入表格部分
            String[] columns = line.split(",");
            buildRow(sb, columns);
        }

        sb.append("</table></body></html>");
        System.out.print(sb.toString());

    }
}