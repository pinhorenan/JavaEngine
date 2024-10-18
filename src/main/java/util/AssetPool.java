package util;

import renderer.Shader;
import renderer.Texture;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("FieldMayBeFinal")
public class AssetPool {
    private static Map<String, Shader> shaders = new HashMap<>();
    private static Map<String, Texture> textures = new HashMap<>();


    // Typically we would call this on our init function to load all the shaders necessary at the start (loading shaders...)
    public static Shader getShader(String resourceName) {
        File file = new File(resourceName);
        // Check for the shader on the shader map
        if (AssetPool.shaders.containsKey(file.getAbsolutePath())) {
            // If found, return it's reference
            return AssetPool.shaders.get(file.getAbsolutePath());
        } else {
            // If not found, create a new shader, add it to the map and return it's reference
            Shader shader = new Shader(resourceName);
            shader.compile();
            AssetPool.shaders.put(file.getAbsolutePath(), shader);
            return shader;
        }
    }

    public static Texture getTexture(String resourceName) {
        File file = new File(resourceName);
        // Check for the texture on the texture map
        if (AssetPool.textures.containsKey(file.getAbsolutePath())) {
            // If found, return it's reference
            System.out.println("Texture found: " + file.getAbsolutePath()); // DEBUG
            return AssetPool.textures.get(file.getAbsolutePath());
        } else {
            // If not found, create a new texture, add it to the map and return it's reference
            System.out.println("Texture not found: " + file.getAbsolutePath()); // DEBUG
            Texture texture = new Texture(resourceName);
            AssetPool.textures.put(file.getAbsolutePath(), texture);
            return texture;
        }
    }

}
