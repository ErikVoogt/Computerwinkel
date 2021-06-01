import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Winkel {

    double kassa = 5000;
    double dagwinst = 0;
    boolean winkelen = true;
    ArrayList<Laptop> laptops = new ArrayList<Laptop>();
    ArrayList<KantEnKlaarSysteem> keksystemen = new ArrayList<>();
    ArrayList<Componenten> componenten = new ArrayList<>();

    public Winkel() {
        for (int i = 0; i < 3; i++) {
            Macbook mb = macBookKopen(1499, "Apple");
            laptops.add(mb);
        }
        for (int i = 0; i < 5; i++){
            Lenovo lv = lenovoKopen(678,"Lenovo");
            laptops.add(lv);
        }
        for (int i = 0; i < 2; i++){
            HP hp = hpKopen(948,"HP");
            laptops.add(hp);
        }
        for (int i = 0; i < 4; i++){
            KantEnKlaarSysteem kek = computerKopen(745);
            keksystemen.add(kek);
        }
        for (int i = 0; i < 5; i++){
            Cpu cpu = new Cpu(250,4.7,"Intel","i5");
            componenten.add(cpu);
        }
        for (int i = 0; i < 2; i++){
            Cpu cpu = new Cpu(279,4.9,"AMD","Ryzen 7");
            componenten.add(cpu);
        }
        for (int i = 0; i <2;i++){
            Gpu gpu = new Gpu(500,"Asus",12,"RTX 3070");
            componenten.add(gpu);
        }
        for (int i = 0; i <1;i++){
            Gpu gpu = new Gpu(379,"MSI",16,"6800XT");
            componenten.add(gpu);
        }
        for (int i = 0; i < 5; i++){
            Ram ram = new Ram(200,16,3200,"Kingston");
            componenten.add(ram);
        }
        for (int i = 0; i < 10; i++){
            Ram ram = new Ram(178,16,3600,"Corsair");
            componenten.add(ram);
        }
        for (int i = 0; i < 3; i++){
            Psu psu = new Psu(84,750,"Seasonic");
            componenten.add(psu);
        }
        for (int i = 0; i < 5; i++){
            Psu psu = new Psu(68,650,"Coolermaster");
            componenten.add(psu);
        }
    }



    KantEnKlaarSysteem computerKopen(int inkoopbedrag) { // kant en klare computer
        Cpu kkcpu = new Cpu(200, 4.7, "intel", "i5");
        Ram kkram = new Ram(82, 16, 3200, "Crucial");
        Psu kkpsu = new Psu(74, 550, "Coolermaster");
        Gpu kkgpu = new Gpu(884, "MSI", 10, "GTX 1660S");
        KantEnKlaarSysteem kkPC = new KantEnKlaarSysteem(inkoopbedrag, kkcpu, kkram, kkpsu, kkgpu);
//         System.out.println(kkPC);
//         System.out.println("De winst is " + kkPC.berekenWinst());
        return kkPC;
    }

    Macbook macBookKopen(int inkoopbedrag, String merk) {
        Cpu macbookcpu = new Cpu(90, 5.1, "Apple Silicon", "M1");
        Ram macbookram = new Ram(84, 8, 2666, "Samsung");
        Psu macbookpsu = new Psu(75, 40, "Apple");
        Gpu macbookgpu = new Gpu(45, "Apple", 2, "Apple Graphics");
        Macbook macbook = new Macbook(inkoopbedrag, macbookcpu, macbookram, macbookpsu, macbookgpu);
        //System.out.println(macbook);
        //System.out.println("De winst is " + macbook.berekenWinst());
        return macbook;
    }

    Lenovo lenovoKopen(int inkoopbedrag, String merk) {
        Cpu lenovocpu = new Cpu(100, 4.6, "AMD", "Ryzen 7");
        Ram lenovoram = new Ram(84, 12, 2100, "Samsung");
        Psu lenovopsu = new Psu(75, 85, "Lenovo");
        Gpu lenovogpu = new Gpu(884, "AMD", 2, "Vega 8");
        Lenovo lenovo = new Lenovo(inkoopbedrag, lenovocpu, lenovoram, lenovopsu, lenovogpu);
        //System.out.println(lenovo);
        //System.out.println("De winst is " + lenovo.berekenWinst());

        return lenovo;
    }

    HP hpKopen(int inkoopbedrag, String merk) {

        Cpu hpcpu = new Cpu(120, 3.7, "Intel", "i3");
        Ram hpram = new Ram(55, 12, 2666, "Supermicro");
        Psu hppsu = new Psu(99, 65, "HP");
        Gpu hpgpu = new Gpu(45, "Nvidia", 2, "MX 350");
        HP hp = new HP(inkoopbedrag, hpcpu, hpram, hppsu, hpgpu);
        //System.out.println(hp);
        //System.out.println("De winst is " + hp.berekenWinst());
        return hp;
    }


    void kiesComputer() {
        while (winkelen) {
            System.out.println("De kassa is: " + kassa);
            System.out.println("Welkom bij de mini computerwinkel.\nKies d voor een desktop of l voor een laptop en q om te stoppen");
            char x = Main.input("dlq");
            switch (x) {
                case 'd':
                    System.out.println("U heeft gekozen voor een desktop.\nKies m voor een maatwerk pc of k voor een kant en klaar systeem");
                    char y = Main.input("mk");
                    switch (y) {
                        case 'm':
                            System.out.println("U heeft gekozen voor een maatwerk pc");
                            MaatwerkComputer mwc = new MaatwerkComputer();
                            List<Componenten> Cpu  = componenten.stream().filter(l -> l instanceof Cpu).collect(Collectors.toList());
                            List<Componenten> Gpu  = componenten.stream().filter(l -> l instanceof Gpu).collect(Collectors.toList());
                            List<Componenten> Psu  = componenten.stream().filter(l -> l instanceof Psu).collect(Collectors.toList());
                            List<Componenten> Ram  = componenten.stream().filter(l -> l instanceof Ram).collect(Collectors.toList());
                            System.out.println("Cpu's: " + Cpu.size());
                            System.out.println("Gpu's: " + Gpu.size());
                            System.out.println("Psu's: " + Psu.size());
                            System.out.println("Ram : " + Ram.size());
                            try{
                                if(Cpu.size() == 0){
                                    throw new OutOfStockException("Sorry de cpu's zijn op");
                                }if(Gpu.size() == 0){
                                    throw new OutOfStockException("Sorry de gpu's zijn op");
                                }if(Psu.size() == 0){
                                    throw new OutOfStockException("Sorry de psu's zijn op");
                                }if(Ram.size() == 0){
                                    throw new OutOfStockException("Sorry de ram is op");
                                }Componenten cpu = Cpu.get(0);
                                componenten.remove(cpu);
                                System.out.println(cpu);
                                Componenten gpu = Gpu.get(0);
                                componenten.remove(gpu);
                                System.out.println(gpu);
                                Componenten psu = Psu.get(0);
                                componenten.remove(psu);
                                System.out.println(psu);
                                Componenten ram = Ram.get(0);
                                componenten.remove(ram);
                                System.out.println(ram);
                            } catch(Exception e){
                                System.out.println(e);
                            }
                            System.out.println("De prijs van de computer is: " + mwc.verkoopbedrag);
                            System.out.println("De inkoopprijs van de computer is: " + mwc.inkoopbedrag);
                            System.out.println("De winst is: " +mwc.berekenAbsoluteWinst());
                            kassa = Main.round(kassa + mwc.berekenAbsoluteWinst());
                            break;
                        case 'k':
                            System.out.println("U heeft gekozen voor een kant en klare pc");
                            List<KantEnKlaarSysteem> keksysteem = keksystemen.stream().filter(l -> l instanceof KantEnKlaarSysteem).collect(Collectors.toList());
                            System.out.println(keksysteem.size());
                            try{
                                if (keksysteem.size() ==0){
                                    throw new OutOfStockException("Sorry de kant en klare systemen zijn uitverkocht");
                                }KantEnKlaarSysteem kek = keksysteem.get(0);
                                keksystemen.remove(kek);
                                System.out.println(kek);
                                System.out.println(kek.berekenWinst());
                                kassa = Main.round(kassa + kek.berekenWinst());
                            }catch(Exception e){
                                System.out.println(e);
                            }

                            break;
                    }
                    break;


                case 'l':
                    System.out.println("U heeft gekozen voor een laptop.\n kies a voor een Apple Macbook, kies h voor een HP, kies m voor een MSI of kies l voor een Lenovo.");
                    char laptop = Main.input("ahml");
                    switch (laptop) {
                        case 'a':
                            System.out.println("U heeft gekozen voor een Apple");
//                             Macbook mb = macBookKopen(1200, "Apple");
                            List<Laptop> macbooks = laptops.stream().filter(l -> l instanceof Macbook).collect(Collectors.toList());
                            System.out.println(macbooks.size());
                            try {
                                if (macbooks.size() == 0) {
                                    throw new OutOfStockException("Sorry de Macbooks zijn uitverkocht");
                                }
                                Macbook mb = (Macbook) macbooks.get(0);
                                laptops.remove(mb);
                                System.out.println(mb);
                                System.out.println(mb.berekenWinst());
                                kassa = Main.round(kassa + mb.berekenWinst());
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 'h':
                            System.out.println("U heeft gekozen voor een HP");
                            //HP hewlett = hpKopen(889, "HP");
                            List<Laptop> Haapee = laptops.stream().filter(l -> l instanceof HP).collect(Collectors.toList());
                            System.out.println(Haapee.size());
                            try {
                                if (Haapee.size() == 0) {
                                    throw new OutOfStockException("Sorry de HP's zijn uitverkocht.");
                                }
                                HP hp = (HP) Haapee.get(0);
                                laptops.remove(hp);
                                System.out.println(hp.berekenWinst());
                                kassa = Main.round(kassa + hp.berekenWinst());
                            } catch ( Exception e){
                                System.out.println(e);
                            }

                            break;

                        case 'l':
                            System.out.println("U heeft gekozen voor een Lenovo");
                            //Lenovo lv = lenovoKopen(669, "Lenovo");
                            List<Laptop> lenovos = laptops.stream().filter(l -> l instanceof Lenovo).collect(Collectors.toList());
                            System.out.println(lenovos.size());
                            try{
                                if(lenovos.size() == 0){
                                    throw new OutOfStockException("Sorry de Lenovo laptops zijn uitverkocht");
                                }
                                Lenovo lv =(Lenovo) lenovos.get(0);
                                laptops.remove(lv);
                                System.out.println(lv.berekenWinst());
                                kassa = Main.round(kassa + lv.berekenWinst());
                            } catch (Exception e){
                                System.out.println(e);
                            }


                            break;
                    }
                    break;
                case 'c':
                    continue;
                case 'q':
                    System.out.println("De Dag is voorbij");
                    winkelen = false;
                    System.out.println("De winst is " + Main.round(kassa - 5000));
                    break;
            }
        }
    }
}
