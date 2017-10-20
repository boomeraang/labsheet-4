package labsheet.computer;

import java.util.Scanner;
import labsheet.storage.*;

class MainMenu
{
    public static void main(String args[])
    {
        int choice;
        boolean response=true;
        User user =new User();
        Scanner input = new Scanner(System.in);

        while(response)
        {
            System.out.println("1.login\n 2.register");
            choice = Integer.parseInt(input.nextLine());

            if(choice!=1 && choice!=2)
            {
                System.out.println("enter valid choice");
                continue;
            }
            else if(choice==2)
                user.RegisterMenu();
            else
                user.LoginMenu();

        }
    }
}

