package lab3;

public class _3 {

    public static void main(String[] args) {
        JuMin j = new JuMin();
        j.setName("张三");
        j.setId("230125198812210124");
        j.setDate(new Date(2024, 3, 26));
        System.out.println(j.getName() + "\t" + j.getId() + "\t" + j.getDate());

        Adult a = new Adult();
        a.setXueLi("本科");
        a.setZhiYe("教师");
        a.setName("张三");
        a.setId("230125198812210124");
        a.setDate(new Date(2024, 3, 26));
        System.out.println(
                a.getName() + "\t" + a.getId() + "\t" + a.getDate() + "\t" + a.getXueLi() + "\t" + a.getZhiYe());

        Official o = new Official();
        o.setDangPai("共产党");
        o.setZhiWu("教Java");
        o.setXueLi("本科");
        o.setZhiYe("教师");
        o.setName("张三");
        o.setId("230125198812210124");
        o.setDate(new Date(2024, 3, 26));
        System.out.println(o.getName() + "\t" + o.getId() + "\t" + o.getDate() + "\t" + o.getXueLi() + "\t"
                + o.getZhiYe() + "\t" + o.getDangPai() + "\t" + o.getZhiWu());
    }
}

class JuMin {
    protected String id;
    protected String name;
    protected Date date;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}

class Adult extends JuMin {
    protected String xueLi, zhiYe;

    public void setXueLi(String xueLi) {
        this.xueLi = xueLi;
    }

    public String getXueLi() {
        return xueLi;
    }

    public void setZhiYe(String zhiYe) {
        this.zhiYe = zhiYe;
    }

    public String getZhiYe() {
        return zhiYe;
    }
}

class Official extends Adult {
    protected String dangPai, zhiWu;

    public void setDangPai(String dangPai) {
        this.dangPai = dangPai;
    }

    public String getDangPai() {
        return dangPai;
    }

    public void setZhiWu(String zhiWu) {
        this.zhiWu = zhiWu;
    }

    public String getZhiWu() {
        return zhiWu;
    }
}

class Date {
    private int year, month, day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%d年%d月%d日", year, month, day);
    }
}