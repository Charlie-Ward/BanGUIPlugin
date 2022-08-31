package bangui.bangui.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private static File file;
    private static FileConfiguration customFile;


    //Finds or generates the custom config file
    public static void setup(){

        file = new File(Bukkit.getServer().getPluginManager().getPlugin("BanGUI").getDataFolder(), "banGUIconfig.yml");

        if (!file.exists()){
            try{

                file.createNewFile();

            }catch (IOException e){

            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get(){

        return customFile;

    }

    public static void save(){

        try{

            customFile.save(file);
            System.out.println("Saved Config File");

        }catch (IOException e){

            System.out.println("Couldn't save Config file");

        }

    }

    public static void reload(){

        customFile = YamlConfiguration.loadConfiguration(file);

    }

}
