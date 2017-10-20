package labsheet.computer;

import java.util.Scanner;
import labsheet.storage.*;

public class Computer {
    private int ram;
    private String processor, motherboard;
    private boolean external_flag,removable_flag;
    Internal internal;
    External external;
    Removable removable;

    public Computer(int ram, String processor, String motherboard, boolean external_flag, boolean removable_flag)
    {
        this.ram = ram;
        this.processor = processor;
        this.motherboard = motherboard;
        this.external_flag = external_flag;
        this.removable_flag = removable_flag;
    }

    void Setram(Scanner input) {
        ram = Integer.parseInt(input.nextLine());
    }

    void Setprocessor(Scanner input) {
        processor = input.nextLine();
    }

    void Setmotherboard(Scanner input) {
        motherboard = input.nextLine();
    }

    public int Getram() {
        return ram;
    }

    public String Getprocessor() {
        return processor;
    }

    public String Getmotherboard() {
        return motherboard;
    }

    public int DeviceMenu()
    {
        int choice,no_of_times=0;
        boolean dont_exit_menu=true;
        Scanner input = new Scanner(System.in);

        while(dont_exit_menu)
        {
            System.out.println("1.write data\n 2.show data 3.back");

            choice = Integer.parseInt(input.nextLine());

            if (choice < 1 && choice > 3)
            {
                System.out.println("enter valid choice");
                continue;
            }

            int internal_external_choice;
            System.out.println("1.internal\n2.external");
            internal_external_choice = Integer.parseInt(input.nextLine());

            if(choice == 3)
                return 0;
            else if(choice == 1)
            {
                if(internal_external_choice == 1)
                {
                    internal = new Internal();

                    System.out.println("this is data before input");
                    internal.InitialiseData();
                    System.out.println(internal.GetData().GetSave());
                    System.out.println("enter data");
                    internal.PersistentSave(input.nextLine());
                    System.out.println("enter internal capacity");
                    internal.Capacity(Integer.parseInt(input.nextLine()));
                    no_of_times++;
                }
                else
                {
                    if(HasRemovable())
                    {
                        removable = new Removable();

                        System.out.println("this is data before input");
                        removable.InitialiseData();
                        System.out.println(removable.GetData().GetSave());
                        System.out.println("enter data");
                        removable.PersistentSave(input.nextLine());
                        System.out.println("enter external capacity");
                        removable.Capacity(Integer.parseInt(input.nextLine()));
                        no_of_times++;
                    }
                }
            }
            else if(choice == 2)
            {
                if(internal_external_choice == 1)
                {
                    System.out.println("capacity = " + internal.GetData().GetCapacity() + "other data:" + internal.GetData().GetSave());
                    no_of_times++;
                }
                else
                {
                    if(HasRemovable())
                    {
                        System.out.println("capacity = " + removable.GetData().GetCapacity() + "other data:" + removable.GetData().GetSave());
                        no_of_times++;
                    }
                }
            }

            System.out.println("do you want to continue y/n");
            String temp_response = input.nextLine();

            if(temp_response.equals("n"))
                dont_exit_menu = false;
        }

        return no_of_times;
    }

    public boolean HasExternal()
    {
        return external_flag;
    }

    public boolean HasRemovable()
    {
        return removable_flag;
    }
}

interface charger
{
    //rate is charge rate per minute
    default int Charge(int charge,int rate,int time)
    {
        return charge+=(rate*time);
    }

    default int ChargeMenu(int charge_during_call,int depreciate)
    {
        charge_during_call -= depreciate*10;

        System.out.println("current charge on your device is " + charge_during_call + "%");
        System.out.println("do you want to charge your device y/n");
        Scanner input = new Scanner(System.in);
        if(input.nextLine().equals("y"))
        {
            System.out.println("how long do you want to charge (in minutes)");
            int charge_time;
            charge_time = Integer.parseInt(input.nextLine());

            charge_during_call = Charge(charge_during_call,1,charge_time);
        }

        System.out.println("power at " + charge_during_call + "%");

        return charge_during_call;
    }

}

class Laptop extends Computer implements charger
{
    private String hostname;
    private int charge;

    public Laptop(int ram,String processor,String motherboard,boolean external,boolean removable)
    {
        super(ram,processor,motherboard,external,removable);
        charge = 100;
    }

    public void Sethostname(Scanner input)
    {
        hostname = input.nextLine();
    }

    public String Gethostname()
    {
        return hostname;
    }

    public int GetCharge()
    {
        return charge;
    }
}

class Desktop extends Computer
{
    private String hostname;

    public Desktop(int ram,String processor,String motherboard, boolean external, boolean removable)
    {
        super(ram,processor,motherboard,external,removable);
    }

    public void Sethostname(Scanner input)
    {
        hostname = input.nextLine();
    }

    public String Gethostname()
    {
        return hostname;
    }
}

class Tablet extends Computer implements charger
{
    private String hostname;
    private int charge;

    public Tablet(int ram,String processor,String motherboard, boolean external, boolean removable)
    {
        super(ram,processor,motherboard,external,removable);
        charge = 100;
    }

    public void Sethostname(Scanner input)
    {
        hostname = input.nextLine();
    }

    public String Gethostname()
    {
        return hostname;
    }

    public int Charge(int charge,int rate,int time)
    {
        return charge+=rate*time;
    }

    public int GetCharge()
    {
        return charge;
    }
}

class Phones extends Computer implements charger
{
    private String hostname;
    private int charge;

    public Phones(int ram,String processor,String motherboard, boolean external, boolean removable)
    {
        super(ram, processor, motherboard,external,removable);
        charge = 100;
    }

    public void Sethostname(Scanner input)
    {
        hostname = input.nextLine();
    }

    public String Gethostname()
    {
        return hostname;
    }

    public int Charge(int charge,int rate,int time)
    {
        return charge+=rate*time;
    }

    public int GetCharge()
    {
        return charge;
    }
}

