#include <iostream>
#include <memory>
#include <string>

using namespace std;

class Shader
{
    string name;
    string type;

public:

    Shader(string name, string type)
        : name(name), type(type)
    {
        cout << "[Shader Compiled]" << endl;
    }

    ~Shader()
    {
        cout << "[Shader Destroyed]" << endl;
    }
};


// Function to get reference count
int getReferenceCount(const shared_ptr<Shader>& shader)
{
    return shader.use_count();
}


int main()
{
    shared_ptr<Shader> shader = make_shared<Shader>("main_vert", "vertex");

    cout << "Ref count: "<< getReferenceCount(shader) << endl;

    {
        shared_ptr<Shader> rendererRef = shader;
        cout << "Ref count: "<< getReferenceCount(shader) << endl;

        shared_ptr<Shader> editorRef = shader;
        cout << "Ref count: "<< getReferenceCount(shader) << endl;
    }
    cout << "Ref count: "<< getReferenceCount(shader) << endl;

    return 0;
}