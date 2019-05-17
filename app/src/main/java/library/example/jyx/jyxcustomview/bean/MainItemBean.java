package library.example.jyx.jyxcustomview.bean;

/**
 * @author jyx
 * @CTime 2019/5/17
 * @explain:
 */
public class MainItemBean {

    private String title;
    private String strDesc;
    private String listType;

    public MainItemBean(String title, String strDesc, String listType) {
        this.title = title;
        this.strDesc = strDesc;
        this.listType = listType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStrDesc() {
        return strDesc;
    }

    public void setStrDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    //直接创建
    public static MainItemBean cresteItem(String title, String listType){
        return  new MainItemBean(title,"",listType);
    }

    public static MainItemBean cresteItem(String title, String strDesc, String listType){
        return  new MainItemBean(title,strDesc,listType);
    }
}
