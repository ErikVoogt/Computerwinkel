import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Main {

    // .... stock
    // constructor



    
    // classes opdelen in losse bestanden
    // OutOfStockException
    // Checken of er stock is
    // in de constructor maken we laptops aan


        // evt. mag je nieuwe modellen
    // 3. voor de onderdelen van de maatwerkcomputer
    public static void main(String[] args) {
        Winkel kiezen = new Winkel();
        kiezen.kiesComputer();
    }

    static char input(String validatie) {
        Scanner input = new Scanner(System.in);
        char x = input.next().charAt(0);

        try {
            if (validatie.indexOf(x) == -1) {
                throw new OngeldigeInvoerException("\nGeldige invoer is: " + validatie);
            }
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 'c';
        }
    }

    static double round(double d) {
        return Math.round(d * 100.0) / 100.0;
    }
}


class OngeldigeInvoerException extends Exception {
    OngeldigeInvoerException(String bericht) {
        super(bericht);
    }
}

class OutOfStockException extends Exception {
    OutOfStockException(String bericht) {
        super(bericht);
    }
}


class Computer {
    protected double verkoopbedrag;
    protected double inkoopbedrag;
    protected Cpu cpu;
    protected Ram ram;
    protected Psu psu;
    protected Gpu gpu;

    double verkoopprijs(double inkoopbedrag) {
        double berekenVerkoopprijs = inkoopbedrag * 1.21 * 1.15;
        return berekenVerkoopprijs;
    }

    double berekenWinst() {
        double winst = verkoopbedrag - (inkoopbedrag) * 1.21;
        return winst;
    }

    public Computer() {
    }

    public Computer(double inkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
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
        String pc = this.getClass().getName() + ":\n  " + this.getCpu() + "\n  " + this.getGpu() + "\n  " + this.getRam() + "\n  " + this.getPsu() +
                "\n Voor de lage prijs van: " + this.verkoopbedrag;
        return pc;
    }
}

class Laptop extends Computer {

    @Override
    double verkoopprijs(double inkoopbedrag) {
        double berekenVerkoopprijs = inkoopbedrag * 1.21 * 1.15;
        return berekenVerkoopprijs;
    }

    public Laptop(double inkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.inkoopbedrag = inkoopbedrag;
        this.verkoopbedrag = verkoopprijs(inkoopbedrag);
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }
}

class Lenovo extends Laptop {
    public Lenovo(double inkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        super(inkoopbedrag, cpu, ram, psu, gpu);
    }
}

class Macbook extends Laptop {
    public Macbook(double inkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        super(inkoopbedrag, cpu, ram, psu, gpu);
    }
}

class HP extends Laptop {
    public HP(double inkoopbedrag, Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        super(inkoopbedrag, cpu, ram, psu, gpu);
    }
}

class KantEnKlaarSysteem extends Computer {
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

class MaatwerkComputer extends Computer {
    double berekenVerkoopPrijs(Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        double verkoopPrijs = (cpu.getInkoopbedrag() + ram.getInkoopbedrag() + psu.getInkoopbedrag() + gpu.getInkoopbedrag()) * 1.21 * 1.15;
        return verkoopPrijs;
    }

    double berekenInkoopPrijs(Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        double inkoopPrijsPlusBTW = (cpu.getInkoopbedrag() + ram.getInkoopbedrag() + psu.getInkoopbedrag() + gpu.getInkoopbedrag()) * 1.21;
        return inkoopPrijsPlusBTW;
    }

    double berekenAbsoluteWinst() {
        double Winst = this.verkoopbedrag - this.inkoopbedrag;
        return Winst;
    }

    public MaatwerkComputer(Cpu cpu, Ram ram, Psu psu, Gpu gpu) {
        this.verkoopbedrag = berekenVerkoopPrijs(cpu, ram, psu, gpu);
        this.inkoopbedrag = berekenInkoopPrijs(cpu, ram, psu, gpu);
        this.cpu = cpu;
        this.ram = ram;
        this.psu = psu;
        this.gpu = gpu;
    }

    public MaatwerkComputer() {
        this.cpu = cpuKiezen();
        this.ram = ramKiezen();
        this.psu = psuKiezen();
        this.gpu = gpuKiezen();
        this.verkoopbedrag = berekenVerkoopPrijs(cpu, ram, psu, gpu);
        this.inkoopbedrag = berekenInkoopPrijs(cpu, ram, psu, gpu);
    }

    Cpu cpuKiezen() {
        System.out.println("Kies a voor een AMD processor of kies i voor een Intel Processor");
        char CPU = Main.input("ai");
        switch (CPU) {
            case 'a':
                System.out.println("AMD");

                Winkel cpuAMD = new Winkel();
                List<Componenten> listAMD = cpuAMD.componenten.stream().filter(l -> l.merk =="AMD").collect(Collectors.toList());
                System.out.println(listAMD.get(0));

                return (Cpu) listAMD.get(0);
            case 'i':
                System.out.println("Intel");

                Winkel cpuIntel = new Winkel();
                List<Componenten> listIntel = cpuIntel.componenten.stream().filter(l -> l.merk == "Intel").collect(Collectors.toList());
                return(Cpu) (listIntel.get(0));

        }
        return null;
    }

    Ram ramKiezen() {
        System.out.println("Kies c voor Corsair geheugen of kies k voor Kingston geheugen");
        char RAM = Main.input("ck");
        switch (RAM) {
            case 'c':
                System.out.println("Corsair");

                Winkel ramCorsair = new Winkel();
                List<Componenten> listCorsair = ramCorsair.componenten.stream().filter(l ->l.merk =="Corsair").collect(Collectors.toList());
                return(Ram) (listCorsair);

            case 'k':
                System.out.println("Kingston");

                Winkel ramKingston = new Winkel();
                List<Componenten> listKingston = ramKingston.componenten.stream().filter(l ->l.merk =="Kingston").collect(Collectors.toList());
                return (Ram) (listKingston);
        }
        return null;
    }

    Psu psuKiezen() {
        System.out.println("Kies s voor een Seasonic voeding of kies c vool een Coolermaster voeding");
        char PSU = Main.input("sc");
        switch (PSU) {
            case 's':
                System.out.println("Seasonic");

                Winkel psuSeasonic = new Winkel();
                List<Componenten> listSeasonic = psuSeasonic.componenten.stream().filter(l -> l.merk == "Seasonic").collect(Collectors.toList());
                return (Psu) (listSeasonic);
            case 'c':
                System.out.println("Coolermaster");

                Winkel psuCoolermaster = new Winkel();
                List<Componenten> listCoolermaster = psuCoolermaster.componenten.stream().filter(l -> l.merk == "Coolermaster").collect(Collectors.toList());
                return (Psu) (listCoolermaster);
        }
        return null;
    }

    Gpu gpuKiezen() {
        System.out.println("Kies a voor een AMD videokaart of kies n voor een Nvidia videokaart");
        char GPU = Main.input("an");
        switch (GPU) {
            case 'a':
                System.out.println("AMD");

                Winkel gpuAmd = new Winkel();
                List<Componenten> listAmd = gpuAmd.componenten.stream().filter(l ->l.merk == "MSI").collect(Collectors.toList());
                return (Gpu)(listAmd);
            case 'n':
                System.out.println("Nvidia");

                Winkel gpuNvidia = new Winkel();
                List<Componenten>listNvidia = gpuNvidia.componenten.stream().filter(l ->l.merk  == "AMD").collect(Collectors.toList());
                return (Gpu)(listNvidia);
        }
        return null;
    }
}

class Componenten {
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

class Cpu extends Componenten {
    private double kloksnelheid;
    private String model;

    double verkoopprijs(double inkoopbedrag) {
        double berekenVerkoopprijs = inkoopbedrag * 1.21 * 1.15;
        return berekenVerkoopprijs;
    }

    double berekenWinst() {
        double winst = verkoopbedrag - (inkoopbedrag) * 1.21;
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
        return "- " + this.merk + " " + this.model + " " + this.kloksnelheid + "Ghz";
    }
}

class Ram extends Componenten {
    private double capaciteit;
    private double kloksnelheid;

    double verkoopprijs(double inkoopbedrag) {
        double berekenVerkoopprijs = inkoopbedrag * 1.21 * 1.15;
        return berekenVerkoopprijs;
    }

    double berekenWinst() {
        double winst = verkoopbedrag - (inkoopbedrag) * 1.21;
        return winst;
    }

    public Ram() {
    }

    public Ram(double inkoopbedrag, double capaciteit, double kloksnelheid, String merk) {
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
        return "- " + this.merk + " " + this.capaciteit + "GB " + this.kloksnelheid + "Mhz";
    }
}

class Psu extends Componenten {
    private double vermogen;

    double verkoopprijs(double inkoopbedrag) {
        double berekenVerkoopprijs = inkoopbedrag * 1.21 * 1.15;
        return berekenVerkoopprijs;
    }

    double berekenWinst() {
        double winst = verkoopbedrag - (inkoopbedrag) * 1.21;
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
        return "- " + this.merk + " " + this.vermogen + "W";
    }
}

class Gpu extends Componenten {
    private double geheugen;
    private String model;

    double verkoopprijs(double inkoopbedrag) {
        double berekenVerkoopprijs = inkoopbedrag * 1.21 * 1.15;
        return berekenVerkoopprijs;
    }

    double berekenWinst() {
        double winst = verkoopbedrag - (inkoopbedrag) * 1.21;
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
        return "- " + this.merk + " " + this.model + " " + this.geheugen + "GB";
    }
}
//         Cpu cpu = new Cpu(200, 4.7, "intel", "i7");
//         Ram ram = new Ram(82, 16, 3000, "Kingston");
//         Psu psu = new Psu(74, 750, "Seasonic");
//         Gpu gpu = new Gpu(884, "Asus", 10, "RTX 3080");
//         MaatwerkComputer PC = new MaatwerkComputer(cpu, ram, psu, gpu);
//         System.out.println(PC);
//         System.out.println("De winst is " + PC.berekenAbsoluteWinst());
//
//
//
//
//         Cpu kkcpu = new Cpu(200, 4.7, "intel", "i5");
//         Ram kkram = new Ram(82, 16, 3200, "Crucial");
//         Psu kkpsu = new Psu(74, 550, "Coolermaster");
//         Gpu kkgpu = new Gpu(884, "MSI", 10, "GTX 1660S");
//         KantEnKlaarSysteem kkPC = new KantEnKlaarSysteem(999, kkcpu, kkram, kkpsu, kkgpu);
//         System.out.println(kkPC);
//         System.out.println("De winst is " + kkPC.berekenWinst());
//
//         Cpu pccpu = new Cpu(200, 5.1, "intel", "i3");
//         Ram pcram = new Ram(55, 12, 2400, "Crucial");
//         Psu pcpsu = new Psu(55, 600, "Antec");
//         Gpu pcgpu = new Gpu(489, "PNY", 8, "RTX 3060");
//         Computer pc = new Computer(550, pccpu, pcram, pcpsu, pcgpu);
//         System.out.println(pc);
//         System.out.println("De winst is " + pc.berekenWinst());
//
//         Cpu intel = new Cpu(200, 2.7, "intel", "Celeron");
//         System.out.println(intel + " Voor de prijs van: " + intel.verkoopprijs(200));
//         System.out.println(intel.berekenWinst());
//
