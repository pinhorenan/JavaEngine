package renderer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

public class Shader {
    private int shaderProgramID;
    private String vertexSource;
    private String fragmentSource;
    private final String filePath;

    // Constructor
    public Shader(String filePath) {
        this.filePath = filePath;
        try {
            String source = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] splitString = source.split("(#type)( )+([a-zA-Z]+)");

            int index, eol;

            // Find the FIRST pattern
            index = source.indexOf("#type") + 6;
            eol = source.indexOf("\r\n", index);
            String firstPattern = source.substring(index, eol).trim();

            // Find the SECOND pattern
            index = source.indexOf("#type", eol) + 6;
            eol = source.indexOf("\r\n", index);
            String secondPattern = source.substring(index, eol).trim();

            // Check the FIRST pattern
            if (firstPattern.equals("vertex")) {
                vertexSource = splitString[1];
            } else if (firstPattern.equals("fragment")) {
                fragmentSource = splitString[1];
            } else {
                throw new IOException("Unexpected token '" + firstPattern + "'");
            }

            // Check the SECOND pattern
            if (secondPattern.equals("vertex")) {
                vertexSource = splitString[2];
            } else if (secondPattern.equals("fragment")) {
                fragmentSource = splitString[2];
            } else {
                throw new IOException("Unexpected token '" + secondPattern + "'");
            }
        } catch (IOException e) {
            e.printStackTrace();
            assert false: "Error: Could not open file for shader: '" + filePath + "'";
        }

        System.out.println(vertexSource);
        System.out.println(fragmentSource);

        if (vertexSource == null) {
            System.out.println("Error: Vertex shader not successfully parsed!");
        }

        if (fragmentSource == null) {
            System.out.println("Error: Fragment shader not successfully parsed!");
        }
    }

    // Compile and link the shader program
    public void compile() {
        // This function compiles AND links the shaders
        int vertexID, fragmentID;

        // =========================================
        // Vertex shader compilation
        // =========================================

            // Load and compile the vertex shader
        vertexID = glCreateShader(GL_VERTEX_SHADER);

            // Pass the shader source to the GPU
        glShaderSource(vertexID, vertexSource);
        glCompileShader(vertexID);

            // Check for errors in compilation (vertex shader)
        int success = glGetShaderi(vertexID, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: '" + filePath + "' \n\tVertex shader compilation failed.");
            System.out.println(glGetShaderInfoLog(vertexID, len));
            assert false : "";
        }

        // =========================================
        // Fragment shader
        // =========================================

            // Load and compile the fragment shader
        fragmentID = glCreateShader(GL_FRAGMENT_SHADER);

            // Pass the shader source to the GPU
        glShaderSource(fragmentID, fragmentSource);
        glCompileShader(fragmentID);

            // Check for errors in compilation (fragment shader)
        success = glGetShaderi(fragmentID, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(fragmentID, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: '" + filePath + "' \n\tFragment shader compilation failed.");
            System.out.println(glGetShaderInfoLog(fragmentID, len));
            assert false : "";
        }

        // =========================================
        // Link shaders
        // =========================================

            // Link the vertex and fragment shader into a shader program
        shaderProgramID= glCreateProgram();
        glAttachShader(shaderProgramID, vertexID);
        glAttachShader(shaderProgramID, fragmentID);
        glLinkProgram(shaderProgramID);

            // Check for linking errors
        success = glGetProgrami(shaderProgramID, GL_LINK_STATUS);
        if (success == GL_FALSE) {
            int len = glGetProgrami(shaderProgramID, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: '" + filePath + "' \n\tLinking of shaders failed.");
            System.out.println(glGetProgramInfoLog(shaderProgramID, len));
            assert false : "";
        }
    }

    // Use the shader program
    public void use() {
        glUseProgram(shaderProgramID);
    }

    // Detach the shader program
    public void detach() {
        glUseProgram(0);
    }
}
