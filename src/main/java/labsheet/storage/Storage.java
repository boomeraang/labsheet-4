package labsheet.storage;

import java.util.Scanner;

public abstract class Storage
{
    Data d;

    abstract void PersistentSave(String x);
    abstract void Capacity(int size);

    public void InitialiseData()
    {
        d = new Data();
    }

    public Data GetData()
    {
        return d;
    }
}
