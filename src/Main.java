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
        System.out.println(PC.berekenAbsoluteWinst());


    }


}

class Computer{

}
class Laptop{
    private int inkoopbedrag;
    private int verkoopbedrag;
    private Cpu cpu;
    private Ram ram;
    private Psu psu;
    private Gpu gpu;

    public Laptop() {
    }

    public Laptop(int inkoopbedrag, int verkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }

    public int getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(int inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public int getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(int verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
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
}
class Lenovo extends Laptop{

}
class Macbook extends Laptop{

}
class HP extends Laptop{

}

class KantEnKlaarSysteem{
    private int inkoopbedrag;
    private int verkoopbedrag;
    private Cpu cpu;
    private Ram ram;
    private Psu psu;
    private Gpu gpu;

    public KantEnKlaarSysteem() {
    }

    public KantEnKlaarSysteem(int inkoopbedrag, int verkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }

    public int getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(int inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public int getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(int verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
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
}
class MaatwerkComputer extends Computer{
    private double verkoopbedrag;
    private Cpu cpu;
    private Ram ram;
    private Psu psu;
    private Gpu gpu;

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


    public double getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(double verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
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
        String weetikveel = this.getClass().getName()+":\n  " + this.getCpu() +"\n  " +this.getGpu() +"\n  " +this.getRam() +"\n  " +this.getPsu()+
                "\n Voor de lage prijs van: "+this.verkoopbedrag;
        return weetikveel;
    }
}
class Cpu{

    private int inkoopbedrag;
    private int verkoopbedrag;
    private double kloksnelheid;
    private String merknaam;
    private String model;

    public Cpu() {
    }

    public Cpu(int inkoopbedrag, int verkoopbedrag, double kloksnelheid, String merknaam, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.kloksnelheid = kloksnelheid;
        this.merknaam = merknaam;
        this.model = model;
    }

    public int getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(int inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public int getVerkoopbedrag() {
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

    private int inkoopbedrag;
    private int verkoopbedrag;
    private int capaciteit;
    private int kloksnelheid;
    private String merk;

    public Ram() {
    }

    public Ram(int inkoopbedrag, int verkoopbedrag, int capaciteit, int kloksnelheid, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.capaciteit = capaciteit;
        this.kloksnelheid = kloksnelheid;
        this.merk = merk;
    }

    public int getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(int inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public int getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(int verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public int getKloksnelheid() {
        return kloksnelheid;
    }

    public void setKloksnelheid(int kloksnelheid) {
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

    private int inkoopbedrag;
    private int verkoopbedrag;
    private int vermogen;
    private String merk;

    public Psu() {
    }

    public Psu(int inkoopbedrag, int verkoopbedrag, int vermogen, String merk) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.vermogen = vermogen;
        this.merk = merk;
    }

    public int getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(int inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public int getVerkoopbedrag() {
        return verkoopbedrag;
    }

    public void setVerkoopbedrag(int verkoopbedrag) {
        this.verkoopbedrag = verkoopbedrag;
    }

    public int getVermogen() {
        return vermogen;
    }

    public void setVermogen(int vermogen) {
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

    private int inkoopbedrag;
    private int verkoopbedrag;
    private String merk;
    private int geheugen;
    private String model;

    public Gpu() {
    }

    public Gpu(int inkoopbedrag, int verkoopbedrag, String merk, int geheugen, String model) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopbedrag;
        this.merk = merk;
        this.geheugen = geheugen;
        this.model = model;
    }

    public int getInkoopbedrag() {
        return inkoopbedrag;
    }

    public void setInkoopbedrag(int inkoopbedrag) {
        this.inkoopbedrag = inkoopbedrag;
    }

    public int getVerkoopbedrag() {
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

    public int getGeheugen() {
        return geheugen;
    }

    public void setGeheugen(int geheugen) {
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