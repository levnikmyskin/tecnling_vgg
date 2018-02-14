package tecnling.euporia.restful.euporiarestful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonProva {
    private String prova1, prova2;
    private int prova3, prova4;

    public String getProva1() {
        return prova1;
    }

    public void setProva1(String prova1) {
        this.prova1 = prova1;
    }

    public String getProva2() {
        return prova2;
    }

    public void setProva2(String prova2) {
        this.prova2 = prova2;
    }

    public int getProva3() {
        return prova3;
    }

    public void setProva3(int prova3) {
        this.prova3 = prova3;
    }

    public int getProva4() {
        return prova4;
    }

    public void setProva4(int prova4) {
        this.prova4 = prova4;
    }
}
