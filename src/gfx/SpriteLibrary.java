package gfx;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
    private Map<String, SpriteSet> units;
    private Map<String, Image> tiles;
    public SpriteLibrary(){
        tiles = new HashMap<>();
        units = new HashMap<>();
        loadSpritesFromDisk();
    }
    private void loadUnits(String path){//Loads Character Images Such as matt and dave. will be adding details for enemies and bosses.
        String[] folderNames = getFolderNames(path );
        for(String folderName: folderNames) {
            SpriteSet spriteSet=new SpriteSet();
            String pathtofolder = path + "/" + folderName;
            String[] sheetsInFolder=getImagesInFolder(pathtofolder);

            for (String sheetName : sheetsInFolder){
                spriteSet.addSheet(
                        sheetName.substring(0, sheetName.length() - 4),
                        ImageUtils.loadImage(pathtofolder + "/" + sheetName)
                );
            }
            units.put(folderName, spriteSet);
        }
    }
    private void loadTiles(String path){// Loads  maps
        String[] imagesInFolder=getImagesInFolder(path);

        for (String fileName : imagesInFolder){
            tiles.put(
                    fileName.substring(0, fileName.length() - 4),
                    ImageUtils.loadImage(path + "/" + fileName)
            );
        }

    }
    private void loadSpritesFromDisk(){
       loadTiles("/sprites/tiles");
       loadUnits("/sprites/units");
    }

    private String[] getImagesInFolder(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isFile());
    }


    private String[] getFolderNames(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }
    public Image getTile( String name){
        return tiles.get(name);
    }
}
