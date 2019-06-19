package mm.com.tabbedactivity;

import android.widget.EditText;

import java.text.DecimalFormat;

public class CalcLength {
    private double sanchi = 0, hnan = 0, mayaw = 0, letthit = 0, maik = 0, htwa = 0, taung = 0, lan = 0, ta = 0,
            outhaba = 0, kawtha = 0, gawout = 0, yuzana = 0, mm = 0, cm = 0, m = 0, km = 0, in = 0, ft = 0, yard = 0, mile = 0;

    private void setMU(double htwa){
        this.htwa = htwa;
        maik = this.htwa * 1.5;
        letthit = maik * 8;
        mayaw = letthit * 4;
        hnan = mayaw * 6;
        sanchi = hnan * 10;
        taung = this.htwa / 2;
        lan = taung / 4;
        ta = lan / 1.75;
        outhaba = ta / 20;
        kawtha = outhaba / 20;
        gawout = kawtha / 4;
        yuzana = gawout / 4;
    }

    private void setMetric(double mm){
        this.mm = mm;
        cm = this.mm / 10;
        m = cm / 100;
        km = m / 1000;
    }

    private void setImperial(double in){
        this.in = in;
        ft = this.in / 12;
        yard = ft / 3;
        mile = yard / 1760;
    }
    //---------------------------------------------------------------------
    private void MUConvert(){
        setImperial(htwa * 9);
        setMetric(htwa * 22.86);
    }
    private void MetricConvert(){
        setImperial(25.4 * mm);
        setMU(mm / 228.6);
    }
    private void ImperialConvert(){
        setMetric(ft * 30.48);
        setMU(in / 9);
    }
//---------------------------------------------------------------------

    private String getSanchi() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(sanchi);
    }

    private void setSanchi(double sanchi) {
        setMU(sanchi / 2880);
        MUConvert();
    }

    private String getHnan() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(hnan);
    }

    private void setHnan(double hnan) {
        setMU(hnan / 288);
        MUConvert();
    }

    private String getMayaw() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(mayaw);
    }

    private void setMayaw(double mayaw) {
        setMU(mayaw / 48);
        MUConvert();
    }

    private String getLetthit() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(letthit);
    }

    private void setLetthit(double letthit) {
        setMU(letthit / 12);
        MUConvert();
    }

    private String getMaik() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(maik);
    }

    private void setMaik(double maik) {
        setMU(maik / 1.5);
        MUConvert();
    }

    private String getHtwa() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(htwa);
    }

    private void setHtwa(double htwa) {
        setMU(htwa);
        MUConvert();
    }

    private String getTaung() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(taung);
    }

    private void setTaung(double taung) {
        setMU(taung * 2);
        MUConvert();
    }

    private String getLan() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(lan);
    }

    private void setLan(double lan) {
        setMU(lan * 8);
        MUConvert();
    }

    private String getTa() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(ta);
    }

    private void setTa(double ta) {
        setMU(ta * 8);
        MUConvert();
    }

    private String getOuthaba() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(outhaba);
    }

    private void setOuthaba(double outhaba) {
        setMU(outhaba * 280);
        MUConvert();
    }

    private String getKawtha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(kawtha);
    }

    private void setKawtha(double kawtha) {
        setMU(kawtha * 5600);
        MUConvert();
    }

    private String getGawout() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(gawout);
    }

    private void setGawout(double gawout) {
        setMU(gawout * 5600 * 4);
        MUConvert();
    }

    private String getYuzana() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(yuzana);
    }

    private void setYuzana(double yuzana) {
        setMU(yuzana *  22400 * 4);
        MUConvert();
    }

    private String getMm() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(mm);
    }

    private void setMm(double mm) {
        setMetric(mm);
        MetricConvert();
    }

    private String getCm() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(cm);
    }

    private void setCm(double cm) {
        setMetric(cm * 10);
        MetricConvert();
    }

    private String getM() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(m);
    }

    private void setM(double m) {
        setMetric(m * 1000);
        MetricConvert();
    }

    private String getKm() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(km);
    }

    private void setKm(double km) {
        setMetric(km * 1000000);
        MetricConvert();
    }

    private String getIn() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(in);
    }

    private void setIn(double in) {
        setImperial(in);
        ImperialConvert();
    }

    private String getFt() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(ft);
    }

    private void setFt(double ft) {
        setImperial(ft * 12);
        ImperialConvert();
    }

    private String getYard() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(yard);
    }

    private void setYard(double yard) {
        setImperial(yard * 3 * 12);
        ImperialConvert();
    }

    private String getMile() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(mile);
    }

    private void setMile(double mile) {
        setImperial(mile * 63360);
        ImperialConvert();
    }


    public String convert(double value, int pos1, int pos2){

        switch(pos1){
            case 0:
                this.setSanchi(value);
                break;
            case 1:
                this.setHnan(value);
                break;
            case 2:
                this.setMayaw(value);
                break;
            case 3:
                this.setLetthit(value);
                break;
            case 4:
                this.setMaik(value);
                break;
            case 5:
                this.setHtwa(value);
                break;
            case 6:
                this.setTaung(value);
                break;
            case 7:
                this.setLan(value);
                break;
            case 8:
                this.setTa(value);
                break;
            case 9:
                this.setOuthaba(value);
                break;
            case 10:
                this.setKawtha(value);
                break;
            case 11:
                this.setGawout(value);
                break;
            case 12:
                this.setYuzana(value);
                break;
            case 13:
                this.setMm(value);
                break;
            case 14:
                this.setCm(value);
                break;
            case 15:
                this.setM(value);
                break;
            case 16:
                this.setKm(value);
                break;
            case 17:
                this.setIn(value);
                break;
            case 18:
                this.setFt(value);
                break;
            case 19:
                this.setYard(value);
                break;
            case 20:
                this.setMile(value);
                break;

            default:
                break;
        }

        switch (pos2){
            case 0:
                return this.getSanchi();
            case 1:
                return this.getHnan();
            case 2:
                return this.getMayaw();
            case 3:
                return this.getLetthit();
            case 4:
                return this.getMaik();
            case 5:
                return this.getHtwa();
            case 6:
                return this.getTaung();
            case 7:
                return this.getLan();
            case 8:
                return this.getTa();
            case 9:
                return this.getOuthaba();
            case 10:
                return this.getKawtha();
            case 11:
                return this.getGawout();
            case 12:
                return this.getYuzana();
            case 13:
                return this.getMm();
            case 14:
                return this.getCm();
            case 15:
                return this.getM();
            case 16:
                return this.getKm();
            case 17:
                return this.getIn();
            case 18:
                return this.getFt();
            case 19:
                return this.getYard();
            case 20:
                return this.getMile();

            default:
                return "";
        }
    }
}
