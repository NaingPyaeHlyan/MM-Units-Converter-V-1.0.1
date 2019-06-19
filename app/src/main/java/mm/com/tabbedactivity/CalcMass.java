package mm.com.tabbedactivity;

import java.text.DecimalFormat;

public class CalcMass {
    private double ywaylay = 0, ywaygyi = 0, petha = 0, mutha = 0,
            mattha = 0, ngamutha = 0, kyattha = 0, peittha = 0, mg = 0, g = 0, kg = 0, oz = 0, lb = 0;

    private void setMU(double kyattha){
        this.kyattha = kyattha;
        ngamutha = this.kyattha * 2;
        mattha = ngamutha * 2;
        mutha = mattha * 2;
        petha = mutha * 2;
        ywaygyi = petha * 3.75;
        ywaylay = ywaygyi * 2;
        peittha = this.kyattha / 100;

    }

    private void setMetric(double mg){
        this.mg = mg;
        g = this.mg / 1000;
        kg = g / 1000;
    }

    private void setImperial(double oz){
        this.oz = oz;
        lb = oz / 16;
    }
    //---------------------------------------------------------------------
    private void MUConvert(){
        setImperial(peittha * 57.6);
        setMetric(kyattha * 16.3239);
    }
    private void MetricConvert(){
        setImperial(g * 28.3495);
        setMU(g / 16.3293);
    }
    private void ImperialConvert(){
        setMU(oz * 28.3495);
        setMetric(oz * 1.7361);
    }
//---------------------------------------------------------------------


    private String getYwaylay() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(ywaylay);
    }

    private void setYwaylay(double ywaylay) {
        setMU(ywaylay / 120);
        MUConvert();
    }

    private String getYwaygyi() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(ywaygyi);
    }

    private void setYwaygyi(double ywaygyi) {
        setMU(ywaygyi / 60);
        MUConvert();
    }

    private String getPetha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(petha);
    }

    private void setPetha(double petha) {
        setMU(petha / 16);
        MUConvert();
    }

    private String getMutha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(mutha);
    }

    private void setMutha(double mutha) {
        setMU(mutha / 8);
        MUConvert();
    }

    private String getMattha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(mattha);
    }

    private void setMattha(double mattha) {
        setMU(mattha / 4);
        MUConvert();
    }

    private String getNgamutha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(ngamutha);
    }

    private void setNgamutha(double ngamutha) {
        setMU(ngamutha / 2);
        MUConvert();
    }

    private String getKyattha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(kyattha);
    }

    private void setKyattha(double kyattha) {
        setMU(kyattha);
        MUConvert();
    }

    private String getPeittha() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(peittha);
    }

    private void setPeittha(double peittha) {
        setMU(peittha * 100);
        MUConvert();
    }

    private String getMg() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(mg);
    }

    private void setMg(double mg) {
        setMetric(mg);
        MetricConvert();
    }

    private String getG() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(g);
    }

    private void setG(double g) {
        setMetric(g * 1000);
        MetricConvert();
    }

    private String getKg() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(kg);
    }

    private void setKg(double kg) {
        setMetric(kg * 1000);
        MetricConvert();
    }

    private String getOz() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(oz);
    }

    private void setOz(double oz) {
        setImperial(oz);
        ImperialConvert();
    }

    private String getLb() {
        DecimalFormat df = new DecimalFormat("#,###,##0.0000");
        return df.format(lb);
    }

    private void setLb(double lb) {
        setImperial(lb * 16);
        ImperialConvert();
    }

    public String convert(double value,int pos1, int pos2){

        switch (pos1) {
            case 0:
                this.setYwaylay(value);
                break;
            case 1:
                this.setYwaygyi(value);
                break;
            case 2:
                this.setPetha(value);
                break;
            case 3:
                this.setMutha(value);
                break;
            case 4:
                this.setMattha(value);
                break;
            case 5:
                this.setNgamutha(value);
                break;
            case 6:
                this.setKyattha(value);
                break;
            case 7:
                this.setPeittha(value);
                break;
            case 8:
                this.setMg(value);
                break;
            case 9:
                this.setG(value);
                break;
            case 10:
                this.setKg(value);
                break;
            case 11:
                this.setOz(value);
                break;
            case 12:
                this.setLb(value);
                break;
            default:
                break;
        }
        switch (pos2) {
            case 0:
                return this.getYwaylay();
            case 1:
                return this.getYwaygyi();

            case 2:
                return this.getPeittha();

            case 3:
                return this.getMutha();

            case 4:
                return this.getMattha();

            case 5:
                return this.getNgamutha();

            case 6:
                return this.getKyattha();

            case 7:
                return this.getPeittha();

            case 8:
                return this.getMg();

            case 9:
                return this.getG();

            case 10:
                return this.getKg();

            case 11:
                return this.getOz();

            case 12:
                return this.getLb();

            default:
                return "";

        }
    }
}