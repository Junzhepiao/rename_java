import java.io.File;
import java.io.IOException;

public class rename_java{
    public static void main(String[] arg) throws IOException{
        String path_to_folder = "/Users/junzhepiao/Desktop/website_wallpaper_sample_28_jpg";
        File my_folder = new File(path_to_folder);
        File[] array_file = my_folder.listFiles();
        for (int i = 0; i < array_file.length; i++){
            if (array_file[i].isFile()){
                File my_file = new File(path_to_folder + "/" + array_file[i].getName());
                String original_name = array_file[i].getName();
                String[] sub_name_array = original_name.split("_");
                String new_name = "";
                for( String each : sub_name_array){
                    if(each.contains("kk") || each.contains("kh") ) {
                        each = each.substring(0,2).toUpperCase() + each.substring(2);
                    }else{
                        each = each.substring(0,1).toUpperCase() + each.substring(1);
                    }

                    if(new_name == ""){
                        new_name = each;
                    }else{
                        new_name = new_name + "_" + each;
                    }
                }
                System.out.println(new_name);
                my_file.renameTo(new File(path_to_folder + "/" + new_name));
            }
        }
    }
}
