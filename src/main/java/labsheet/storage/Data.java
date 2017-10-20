package labsheet.storage;

import java.util.Scanner;

public class Data
{
    int int_data;
    float float_data;
    String string_data;

    public void Setint(Scanner input)
    {
        int_data = Integer.parseInt(input.nextLine());
    }

    public void Setfloat(Scanner input)
    {
        float_data = Float.parseFloat(input.nextLine());
    }

    public void Setstring(Scanner input)
    {
        string_data = input.nextLine();
    }

    public int GetCapacity()
    {
        return int_data;
    }

    public String GetSave()
    {
        return string_data;
    }


}

