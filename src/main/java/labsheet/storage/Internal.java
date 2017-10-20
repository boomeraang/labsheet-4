package labsheet.storage;

public class Internal extends Storage
{
    public void PersistentSave(String x)
    {
        /*StringBuilder temp = new StringBuilder(d.string_data);
        temp.append(x);
        d.string_data = temp.toString();*/

        d.string_data += x;
    }

    public void Capacity(int size)
    {
        d.int_data = size;
    }


}
