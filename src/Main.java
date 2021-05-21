import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Winstberekenen voor alle klassen ook voor de losse onderdelen
        // klasse aanmaken winkel met methode voor keuzemenu.
        // gebruiker voert 1 char in. Op basis daarvan een PC of laptop te selecteren.
        // druk op q om het programma te stoppen.
        // het programma moet zichzelf herhalen.
        Cpu cpu = new Cpu(200,4.7,"intel","i7");
        Ram ram = new Ram(82, 16, 3000,"Kingston");
        Psu psu = new Psu(74,750,"Seasonic");
        Gpu gpu = new Gpu(884,"Asus",10,"RTX 3080");
        MaatwerkComputer PC = new MaatwerkComputer(cpu,ram,psu,gpu);
        System.out.println(PC);
        System.out.println("De winst is " + PC.berekenAbsoluteWinst());
        Cpu lenovocpu = new Cpu(100,4.6,"AMD","Ryzen 7");
        Ram lenovoram = new Ram(84, 12, 2100,"Samsung");
        Psu lenovopsu = new Psu(75,85,"Lenovo");
        Gpu lenovogpu = new Gpu(884,"AMD",2,"Vega 8");
        Lenovo lenovo = new Lenovo(999,lenovocpu,lenovoram,lenovopsu,lenovogpu);
        System.out.println(lenovo);
        System.out.println("De winst is " +lenovo.berekenWinst());

        Cpu macbookcpu = new Cpu(90,5.1,"Apple Silicon","M1");
        Ram macbookram  = new Ram(84, 8, 2666,"Samsung");
        Psu macbookpsu = new Psu(75,40,"Apple");
        Gpu macbookgpu = new Gpu(45,"Apple",2,"Apple Graphics");
        Macbook macbook = new Macbook(1158,macbookcpu,macbookram,macbookpsu,macbookgpu);
        System.out.println(macbook);
        System.out.println("De winst is "+ macbook.berekenWinst());

        Cpu hpcpu = new Cpu(120,3.7,"Intel","i3");
        Ram hpram  = new Ram(55, 12, 2666,"Supermicro");
        Psu hppsu = new Psu(99,65,"HP");
        Gpu hpgpu = new Gpu(45,"Nvidia",2,"MX 350");
        HP hp = new HP(750, hpcpu,hpram,hppsu,hpgpu);
        System.out.println(hp);
        System.out.println("De winst is "+ hp.berekenWinst());

        Cpu kkcpu = new Cpu(200,4.7,"intel","i5");
        Ram kkram = new Ram(82, 16, 3200,"Crucial");
        Psu kkpsu = new Psu(74,550,"Coolermaster");
        Gpu kkgpu = new Gpu(884,"MSI",10,"GTX 1660S");
        KantEnKlaarSysteem kkPC = new KantEnKlaarSysteem(999,kkcpu,kkram,kkpsu,kkgpu);
        System.out.println(kkPC);
        System.out.println("De winst is "+ kkPC.berekenWinst());

        Cpu pccpu = new Cpu(200,5.1,"intel","i3");
        Ram pcram = new Ram(55,12,2400,"Crucial");
        Psu pcpsu = new Psu(55,600,"Antec");
        Gpu pcgpu = new Gpu(489,"PNY",8,"RTX 3060");
        Computer pc = new Computer(550,pccpu,pcram,pcpsu,pcgpu);
        System.out.println(pc);
        System.out.println("De winst is "+ pc.berekenWinst());

        Cpu intel = new Cpu(200,2.7,"intel","Celeron");
        System.out.println(intel + " Voor de prijs van: " + intel.verkoopprijs(200));
        System.out.println(intel.berekenWinst());

        Winkel kiezen = new Winkel();
        kiezen.kiesComputer();






    }


}

class Winkel{
    boolean winkelen= true;

    void kiesComputer(){
        while(winkelen) {
            Scanner invoer = new Scanner(System.in);
            System.out.println("Welkom bij de mini computerwinkel.\nKies d voor een desktop of l voor een laptop en q om te stoppen");
            String keuze = invoer.nextLine();
            if (keuze.equals("d")) {
                Scanner pc = new Scanner(System.in);
                System.out.println("U heeft gekozen voor een desktop.\nKies m voor een maatwerk pc of k voor een kant en klaar systeem");
                String x = pc.nextLine();
                if (x.equals("m")) {
                    System.out.println("U heeft gekozen voor een maatwerk pc");
                } else if (x.equals("k")) {
                    System.out.println("U heeft gekozen voor een kant en klare pc");
                }
            } else if (keuze.equals("l")) {
                Scanner y = new Scanner(System.in);
                System.out.println("U heeft gekozen voor een laptop.\n kies a voor een Apple Macbook, kies h voor een HP, kies m voor een MSI of kies l voor een Lenovo.");
                String laptop = y.nextLine();
                if (laptop.equals("a")) {
                    System.out.println("U heeft gekozen voor een Apple");
                } else if (laptop.equals("h")) {
                    System.out.println("U heeft gekozen voor een HP");
                } else if (laptop.equals("m")) {
                    System.out.println("U heeft gekozen voor een MSI");
                } else if (laptop.equals("l")) {
                    System.out.println("U heeft gekozen voor een Lenovo");
                }
            } else if (keuze.equals("q")) {
                System.out.println("Kijken kijken niet kopen.");
            }
        }

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
    double berekenWinst(){
        double winst = verkoopbedrag - (inkoopbedrag)*1.21;
        return winst;
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

    public KantEnKlaarSysteem() {
    }

    public KantEnKlaarSysteem(double inkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
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

    double verkoopprijs( double inkoopbedrag){
        double berekenVerkoopprijs = inkoopbedrag *1.21*1.15;
        return berekenVerkoopprijs;
    }
    double berekenWinst(){
        double winst = verkoopbedrag - (inkoopbedrag)*1.21;
        return winst;
    }



    public Cpu() {
    }

    public Cpu(double inkoopbedrag, double kloksnelheid, String merknaam, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
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


    double verkoopprijs( double inkoopbedrag){
        double berekenVerkoopprijs = inkoopbedrag *1.21*1.15;
        return berekenVerkoopprijs;
    }
    double berekenWinst(){
        double winst = verkoopbedrag - (inkoopbedrag)*1.21;
        return winst;
    }


    public Ram() {
    }

    public Ram(double inkoopbedrag,double capaciteit, double kloksnelheid, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
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
class Psu {
    private double inkoopbedrag;
    private double verkoopbedrag;
    private double vermogen;
    private String merk;


    double verkoopprijs( double inkoopbedrag){
        double berekenVerkoopprijs = inkoopbedrag *1.21*1.15;
        return berekenVerkoopprijs;
    }
    double berekenWinst(){
        double winst = verkoopbedrag - (inkoopbedrag)*1.21;
        return winst;
    }


    public Psu() {
    }

    public Psu(double inkoopbedrag, double vermogen, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
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
class Gpu {
    private double inkoopbedrag;
    private double verkoopbedrag;
    private String merk;
    private double geheugen;
    private String model;


    double verkoopprijs( double inkoopbedrag){
        double berekenVerkoopprijs = inkoopbedrag *1.21*1.15;
        return berekenVerkoopprijs;
    }
    double berekenWinst(){
        double winst = verkoopbedrag - (inkoopbedrag)*1.21;
        return winst;
    }


    public Gpu() {
    }

    public Gpu(double inkoopbedrag, String merk, double geheugen, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
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