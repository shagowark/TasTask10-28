import ConsoleModule.CmdLineArgsParser;
import JFrameModule.Frame;
import LogicModule.AdvertFilter;
import LogicModule.Apartment;
import LogicModule.Logic;

import java.util.ArrayList;

//флажок для каждого параметра фильтра - возможность задать через консоль
public class Main {
    public static void main(String[] args) throws Exception{

        if (args.length == 0) {
            new Frame();
        } else {
            runInConsole(args);
        }
    }

    private static void runInConsole (String[] args) throws Exception {
        CmdLineArgsParser argsParser = new CmdLineArgsParser(args);

        String inputFilePath = argsParser.getArgumentValue("-i", "--input-file");
        String outputFilePath = argsParser.getArgumentValue("-o", "--output-file");


        ArrayList<Apartment> apartList = new ArrayList<>(Logic.readApartsListFromFile(inputFilePath));
        Logic.checkIfArrayListIsNull(apartList);
        Logic.checkIfArrayListIsEmpty(apartList);

        AdvertFilter filter = new AdvertFilter();
        filter.setFilterArgsFromCmd(argsParser.getArgsDict());

        ArrayList<Apartment> goodAparts = new ArrayList<>(Logic.filterAparts(apartList, filter));
        if (goodAparts.size() == 0) {
            Logic.saveOutputIntoFile(outputFilePath, "Подходящих квартир не найдено");
        } else {
            Logic.saveOutputIntoFile(outputFilePath, goodAparts);
        }
    }
}
