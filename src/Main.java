public class Main {

    public static void main(String[] args) {
        // onderdelen maken
        // Maatwerk computer maken
        Cpu cpu = new Cpu(200,250,4.7,"intel","i7");
        Ram ram = new Ram(82,109, 16, 3000,"Kingston");
        Psu psu = new Psu(74,115,750,"Seasonic");
        Gpu gpu = new Gpu(884,1499,"Asus",10,"RTX 3080");
        MaatwerkComputer PC = new MaatwerkComputer(cpu,ram,psu,gpu);
        System.out.println(PC);
        System.out.println("De winst is " + PC.berekenAbsoluteWinst());
        Cpu lenovocpu = new Cpu(100,250,4.6,"AMD","Ryzen 7");
        Ram lenovoram = new Ram(84,109, 12, 2100,"Samsung");
        Psu lenovopsu = new Psu(75,115,85,"Lenovo");
        Gpu lenovogpu = new Gpu(884,1499,"AMD",2,"Vega 8");
        Lenovo lenovo = new Lenovo(999,lenovocpu,lenovoram,lenovopsu,lenovogpu);
        System.out.println(lenovo);

        Cpu macbookcpu = new Cpu(90,340,5.1,"Apple Silicon","M1");
        Ram macbookram  = new Ram(84,109, 8, 2666,"Samsung");
        Psu macbookpsu = new Psu(75,115,40,"Apple");
        Gpu macbookgpu = new Gpu(45,88,"Apple",2,"Apple Graphics");
        Macbook macbook = new Macbook(1158,macbookcpu,macbookram,macbookpsu,macbookgpu);
        System.out.println(macbook);

        Cpu hpcpu = new Cpu(120,340,3.7,"Intel","i3");
        Ram hpram  = new Ram(55,109, 12, 2666,"Supermicro");
        Psu hppsu = new Psu(99,115,65,"HP");
        Gpu hpgpu = new Gpu(45,88,"Nvidia",2,"MX 350");
        HP hp = new HP(750, hpcpu,hpram,hppsu,hpgpu);
        System.out.println(hp);

        Cpu kkcpu = new Cpu(200,250,4.7,"intel","i5");
        Ram kkram = new Ram(82,109, 16, 3200,"Crucial");
        Psu kkpsu = new Psu(74,115,550,"Coolermaster");
        Gpu kkgpu = new Gpu(884,1499,"MSI",10,"GTX 1660S");
        KantEnKlaarSysteem kkPC = new KantEnKlaarSysteem(777,999,kkcpu,kkram,kkpsu,kkgpu);
        System.out.println(kkPC);

        Cpu pccpu = new Cpu(200,250,5.1,"intel","i3");
        Ram pcram = new Ram(55,99,12,2400,"Crucial");
        Psu pcpsu = new Psu(55,79,600,"Antec");
        Gpu pcgpu = new Gpu(489,749,"PNY",8,"RTX 3060");
        Computer pc = new Computer(550,pccpu,pcram,pcpsu,pcgpu);
        System.out.println(pc);





    }


}

class Computer{
    protected double verkoopbedrag;
    protected double inkoopbedrag;
    protected Cpu cpu;
    protected Ram ram;
    protected Psu psu;
    protected Gpu gpu;


    double verkoopprijs( double inkoopbedrag){
        double berekenVerkoopprijs = inkoopbedrag *1.21*1.15;
        return berekenVerkoopprijs;
    }


    public Computer() {
    }

    public Computer(double inkoopbedrag,Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag= verkoopprijs(inkoopbedrag);
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Psu getPsu() {
        return psu;
    }

    public void setPsu(Psu psu) {
        this.psu = psu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }
    @Override
    public String toString() {
        String pc = this.getClass().getName()+":\n  " + this.getCpu() +"\n  " +this.getGpu() +"\n  " +this.getRam() +"\n  " +this.getPsu()+
                "\n Voor de lage prijs van: "+this.verkoopbedrag;
        return pc;
    }
}
class Laptop extends Computer{

    @Override
    double verkoopprijs( double inkoopbedrag){
        double berekenVerkoopprijs = inkoopbedrag *1.21*1.15;
        return berekenVerkoopprijs;
    }



    public Laptop( double inkoopbedrag,Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;



    }


}
class Lenovo extends Laptop{



    public Lenovo(double inkoopbedrag,Cpu cpu, Ram ram, Psu psu, Gpu gpu){

        super(inkoopbedrag,cpu,ram,psu,gpu);


    }




}
class Macbook extends Laptop{

    public Macbook(double inkoopbedrag,Cpu cpu, Ram ram, Psu psu, Gpu gpu){

        super(inkoopbedrag,cpu,ram,psu,gpu);
    }

}
class HP extends Laptop{

    public HP (double inkoopbedrag,Cpu cpu, Ram ram, Psu psu, Gpu gpu){

        super(inkoopbedrag,cpu,ram,psu,gpu);
    }

}
class KantEnKlaarSysteem extends Computer{
    private double inkoopbedrag;


    public KantEnKlaarSysteem() {
    }

    public KantEnKlaarSysteem(double inkoopbedrag, double verkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }


}
class MaatwerkComputer extends Computer{


    double berekenVerkoopPrijs (Cpu cpu, Ram ram , Psu psu , Gpu gpu){
       double verkoopPrijs =(cpu.getInkoopbedrag() + ram.getInkoopbedrag() + psu.getInkoopbedrag() + gpu.getInkoopbedrag())*1.21*1.15;


        return verkoopPrijs ;
    }
    double berekenAbsoluteWinst(){
        double inkoopPrijsPlusBTW =(cpu.getInkoopbedrag() + ram.getInkoopbedrag() + psu.getInkoopbedrag() + gpu.getInkoopbedrag())*1.21;
        double verkoopPrijsPlusBTW =(cpu.getInkoopbedrag() + ram.getInkoopbedrag() + psu.getInkoopbedrag() + gpu.getInkoopbedrag())*1.21*1.15;
        double Winst = verkoopPrijsPlusBTW - inkoopPrijsPlusBTW;
        return Winst;
    }




    public MaatwerkComputer( Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.verkoopbedrag = berekenVerkoopPrijs(cpu,ram,psu,gpu);
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }


}
class Cpu{

    private double inkoopbedrag;
    private double verkoopbedrag;
    private double kloksnelheid;
    private String merknaam;
    private String model;

    public Cpu() {
    }

    public Cpu(double inkoopbedrag, double verkoopbedrag, double kloksnelheid, String merknaam, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.kloksnelheid = kloksnelheid;
        this.merknaam = merknaam;
        this.model = model;
    }

    public double getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(double inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public double getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(int verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
    }

    public double getKloksnelheid() {
        return kloksnelheid;
    }

    public void setKloksnelheid(double kloksnelheid) {
        this.kloksnelheid = kloksnelheid;
    }

    public String getMerknaam() {
        return merknaam;
    }

    public void setMerknaam(String merknaam) {
        this.merknaam = merknaam;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "- " + this.merknaam +" "+ this.model +" "+ this.kloksnelheid+"Ghz";
    }
}
class Ram{

    private double inkoopbedrag;
    private double verkoopbedrag;
    private double capaciteit;
    private double kloksnelheid;
    private String merk;

    public Ram() {
    }

    public Ram(double inkoopbedrag, double verkoopbedrag, double capaciteit, double kloksnelheid, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.capaciteit = capaciteit;
        this.kloksnelheid = kloksnelheid;
        this.merk = merk;
    }

    public double getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(double inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public double getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(double verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
    }

    public double getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(double capaciteit) {
        this.capaciteit = capaciteit;
    }

    public double getKloksnelheid() {
        return kloksnelheid;
    }

    public void setKloksnelheid(double kloksnelheid) {
        this.kloksnelheid = kloksnelheid;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
    @Override
    public String toString() {
        return "- " + this.merk +" "+ this.capaciteit +"GB "+ this.kloksnelheid+"Mhz";
    }
}
class Psu{

    private double inkoopbedrag;
    private double verkoopbedrag;
    private double vermogen;
    private String merk;

    public Psu() {
    }

    public Psu(double inkoopbedrag, double verkoopbedrag, double vermogen, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.vermogen = vermogen;
        this.merk = merk;
    }

    public double getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(double inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public double getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(double verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
    }

    public double getVermogen() {
        return vermogen;
    }

    public void setVermogen(double vermogen) {
        this.vermogen = vermogen;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
    @Override
    public String toString() {
        return "- " + this.merk +" "+ this.vermogen+"W";
    }
}
class Gpu{

    private double inkoopbedrag;
    private double verkoopbedrag;
    private String merk;
    private double geheugen;
    private String model;

    public Gpu() {
    }

    public Gpu(double inkoopbedrag, double verkoopbedrag, String merk, double geheugen, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.merk = merk;
        this.geheugen = geheugen;
        this.model = model;
    }

    public double getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(double inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public double getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(int verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getGeheugen() {
        return geheugen;
    }

    public void setGeheugen(double geheugen) {
        this.geheugen = geheugen;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "- " + this.merk +" "+ this.model +" "+ this.geheugen+"GB";
    }
}