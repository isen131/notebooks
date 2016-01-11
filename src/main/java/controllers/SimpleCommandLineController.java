package controllers;

import model.Params;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июн 10
 */
public class SimpleCommandLineController implements CommandLineController
{

    private static final CommandLineController instance = new SimpleCommandLineController();

    public static CommandLineController getInstance()
    {
        return instance;
    }

    private SimpleCommandLineController()
    {
    }

    private String[] getFormattedData(String[] row_data, int elemNumber)
    {
        String[] result = new String[elemNumber + 1];
        for (int i = 0; i < elemNumber; i++)
        {
            result[i] = row_data[i];
        }
        for (int i = elemNumber; i < row_data.length; i++)
        {
            result[elemNumber] += row_data[i] + " ";
        }
        return result;
    }

    @Override
    public Params parseCommandLineString(String commandLine)
    {
        String cmd_name = null;
        String[] cmd_args = null;

        String[] row_data = StringUtils.split(commandLine, " | ");



        if (row_data == null || row_data.length == 0)
            return new Params("", new String[]{""});

        cmd_name = row_data[0];

        String[] formattedData;

        switch (cmd_name)
        {
            case "add": formattedData = getFormattedData(row_data, 3);
                break;
            case "update": formattedData = getFormattedData(row_data, 4);
                break;
            default: formattedData = getFormattedData(row_data, 0);
                break;
        }

        String[] row_args = Arrays.copyOfRange(formattedData, 1, formattedData.length);
        cmd_args = row_args;
        //cmd_args = StringUtils.join(row_args, " ");

        return new Params(cmd_name, cmd_args);
    }
}
