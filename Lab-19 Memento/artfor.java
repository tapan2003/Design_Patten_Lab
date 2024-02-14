import java.util.*;

class ArticleOriginator {
    private String content;
    private int fontSize;
    private String fontType;

    public ArticleOriginator(String content, int fontSize, String fontType) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public ArticleMemento saveArticleState() {
        return new ArticleMemento(content, fontSize, fontType);
    }

    public void restoreArticleState(ArticleMemento m) {
        content = m.getContent();
        fontSize = m.getFontSize();
        fontType = m.getFontType();
    }

    public void displayArticle() {
        System.out.println(
                "This article has content: " + content + " with font-size: " + fontSize + " and font-type: "
                        + fontType);
    }
}

class ArticleMemento {
    private String content;
    private int fontSize;
    private String fontType;

    public ArticleMemento(String content, int fontSize, String fontType) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    public String getContent() {
        return content;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontType() {
        return fontType;
    }
}

class Caretaker {
    List<ArticleMemento> lm = new ArrayList<ArticleMemento>();

    public void addArticleMemento(ArticleMemento m) {
        lm.add(m);
    }

    public ArticleMemento getArticleMemento(int i) {
        return lm.get(i);
    }
}

public class artfor {
    public static void main(String[] args) {
        ArticleOriginator a1 = new ArticleOriginator("Java Is Fun!!!", 14, "Calibri");
        a1.displayArticle();

        ArticleMemento am = a1.saveArticleState();

        Caretaker caretaker = new Caretaker();
        caretaker.addArticleMemento(am);

        a1.setContent("OOPs With JAVA!!!");
        a1.setFontSize(36);
        a1.setFontType("Times New Roman");
        a1.displayArticle();

        a1.restoreArticleState(caretaker.getArticleMemento(0));
        a1.displayArticle();
    }
}
