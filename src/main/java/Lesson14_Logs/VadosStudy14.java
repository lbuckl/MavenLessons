package Lesson14_Logs;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class VadosStudy14 {

    public static void main(String[] args) throws NotFind4Exeption {

        int arr[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        CutArray cutArray = new CutArray();

        for (int el:cutArray.returnCustomArr(arr,4)) {
            System.out.print(el + " ");
        }
        System.out.println();

        Search search = new Search();
        System.out.println(search.chechNums(arr,4,1));
        //___________________________________________________

        //region подключение логера
        try {
            LogManager.getLogManager().readConfiguration(
                    VadosStudy14.class.getResourceAsStream("/config/log.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Logger logger = Logger.getLogger(VadosStudy14.class.getName());
        //endregion

        logger.info("какая-то надпись");
        logger.warning("какая-то надпись");
    }

}
