package labsheet.computer;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

class User
{
    String username,password;
    static ArrayList<User> user_list = new ArrayList<User>();

    public String Getusername()
    {
        return username;
    }

    public void RegisterMenu()
    {
        String temp_username,temp_password;
        Scanner input = new Scanner(System.in);

        /*Console input = System.console();
        if (input == null)
            System.out.println("console instance not created");*/

        System.out.println("create username");
        temp_username = new String(input.nextLine());
        System.out.println("enter password");
        temp_password = new String(input.nextLine());

        User new_user = new User();
        new_user.username = temp_username;
        new_user.password = temp_password;
        user_list.add(new_user);
    }

    public void LoginMenu()
    {
        boolean response=true;

        /* get a true console and try it out sometime
        Console console_input = System.console();
        if (console_input == null)
            System.out.println("console instance not created");*/

        String login_username = new String();
        Scanner input = new Scanner(System.in);

        while(response)
        {
            System.out.println("enter username");
            login_username = input.nextLine();
            System.out.println("enter password");
            String login_password = new String(input.nextLine());

            for(User temp: user_list)
            {
                if(temp.username.equals(login_username) && temp.password.equals(login_password))
                {
                    System.out.println("welcome "+temp.username);

                    int device_choice;

                    System.out.println("what device do you have\n 1.laptop\n 2.tablet\n 3.phone\n 4.desktop\n 5.back");
                    device_choice = Integer.parseInt(input.nextLine());

                    if(device_choice <1 && device_choice>5)
                    {
                        System.out.println("enter a valid choice");
                        continue;
                    }
                    else if(device_choice == 5)
                        return;

                    String temp_string_processor,temp_string_motherboard;
                    int temp_ram;

                    System.out.println("enter motherboard name");
                    temp_string_motherboard = input.nextLine();
                    System.out.println("enter processor name");
                    temp_string_processor = input.nextLine();
                    System.out.println("enter amount of ram");
                    temp_ram = Integer.parseInt(input.nextLine());

                    int charge_depreciate_times=1;

                    if(device_choice == 1)
                    {
                        Laptop device = new Laptop(temp_ram,temp_string_processor,temp_string_motherboard,true,true);
                        charge_depreciate_times = device.DeviceMenu();
                        device.ChargeMenu(device.GetCharge(),charge_depreciate_times);
                    }
                    else if(device_choice == 2)
                    {
                        Tablet device = new Tablet(temp_ram,temp_string_processor,temp_string_motherboard,false,false);
                        device.DeviceMenu();
                        device.ChargeMenu(device.GetCharge(),charge_depreciate_times);
                    }
                    else if(device_choice == 3)
                    {
                        Phones device = new Phones(temp_ram,temp_string_processor,temp_string_motherboard,false,false);
                        device.DeviceMenu();
                        device.ChargeMenu(device.GetCharge(),charge_depreciate_times);
                    }
                    else if(device_choice == 4)
                    {
                        Desktop device = new Desktop(temp_ram,temp_string_processor,temp_string_motherboard,true,true);
                        device.DeviceMenu();
                    }

                    break;
                }
            }

            System.out.println("do you want to continue y/n");
            String temp = input.nextLine();

            if(temp.equals("y"))
                response = true;
            else
                response = false;
        }
    }
}
