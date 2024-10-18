#type vertex
#version 330 core
layout (location=0) in vec3 aPosition;
layout (location=1) in vec4 aColor;
layout (location=2) in vec2 aTextureCoordinates;
layout (location=3) in float aTextureID;

uniform mat4 uProjection;
uniform mat4 uView;

out vec4 fColor;
out vec2 fTextureCoordinates;
out float fTextureID;

void main()
{
    fColor = aColor;
    fTextureCoordinates = aTextureCoordinates;
    fTextureID = aTextureID;

    gl_Position = uProjection * uView * vec4(aPosition, 1.0);
}

#type fragment
#version 330 core

in vec4 fColor;
in vec2 fTextureCoordinates;
in float fTextureID;

uniform sampler2D uTextures[8];

out vec4 color;

void main()
{
    if(fTextureID > 0) {
        int ID = int(fTextureID); // Just cast the float to an int
        color = fColor * texture(uTextures[ID], fTextureCoordinates);
        //color = vec4(fTexCoords, 0, 1); // (x, y, 0, 1)
    } else {
        color = fColor;
    }
}