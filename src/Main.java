import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // vanaf switch case naar nieuwe methode.
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
            char x = invoer.next().charAt(0);
            switch (x) {
                case 'd':
                    Scanner pc = new Scanner(System.in);
                    System.out.println("U heeft gekozen voor een desktop.\nKies m voor een maatwerk pc of k voor een kant en klaar systeem");
                    char y = pc.next().charAt(0);
                    switch (y) {
                        case 'm':
                        System.out.println("U heeft gekozen voor een maatwerk pc");
                        break;
                        case 'k':
                        System.out.println("U heeft gekozen voor een kant en klare pc");
                        break;
                    } break;



                case 'l' :
                Scanner p = new Scanner(System.in);
                System.out.println("U heeft gekozen voor een laptop.\n kies a voor een Apple Macbook, kies h voor een HP, kies m voor een MSI of kies l voor een Lenovo.");
                char laptop = p.next().charAt(0);
                switch(laptop){
                    case 'a' :

                    System.out.println("U heeft gekozen voor een Apple");

                    break;

                    case 'h':

                        System.out.println("U heeft gekozen voor een HP");

                    break;

                    case 'm':
                    System.out.println("U heeft gekozen voor een MSI");

                    break;

                    case 'l':
                    System.out.println("U heeft gekozen voor een Lenovo");

                    break;
                }

                break;
                case 'q':
                System.out.println("Kijken kijken niet kopen.");
                winkelen = false;
                break;
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
class Componenten{
    protected double inkoopbedrag;
    protected double verkoopbedrag;
    protected String merk;

    public Componenten() {
    }

    public Componenten(double inkoopbedrag, double verkoopbedrag, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
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

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
class Cpu extends Componenten{

    private double kloksnelheid;
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

    public Cpu(double inkoopbedrag, double kloksnelheid, String merk, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
        this.kloksnelheid = kloksnelheid;
        this.merk = merk;
        this.model = model;
    }


    public double getKloksnelheid() {
        return kloksnelheid;
    }

    public void setKloksnelheid(double kloksnelheid) {
        this.kloksnelheid = kloksnelheid;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "- " + this.merk +" "+ this.model +" "+ this.kloksnelheid+"Ghz";
    }
}
class Ram extends Componenten{
    private double capaciteit;
    private double kloksnelheid;



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

    @Override
    public String toString() {
        return "- " + this.merk +" "+ this.capaciteit +"GB "+ this.kloksnelheid+"Mhz";
    }
}
class Psu extends Componenten {

    private double vermogen;



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



    public double getVermogen() {
        return vermogen;
    }

    public void setVermogen(double vermogen) {
        this.vermogen = vermogen;
    }

    @Override
    public String toString() {
        return "- " + this.merk +" "+ this.vermogen+"W";
    }
}
class Gpu extends Componenten{
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