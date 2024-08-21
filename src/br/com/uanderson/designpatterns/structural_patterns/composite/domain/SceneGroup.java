package br.com.uanderson.designpatterns.structural_patterns.composite.domain;

import java.util.ArrayList;
import java.util.List;

public class SceneGroup  implements SceneObject{
    //Representa um Composite - Agrupador de elementos
    private String name;
    private List<SceneObject> children = new ArrayList<>();

    public SceneGroup(String name) {
        this.name = name;
    }

    public void add(SceneObject object){
        children.add(object);
    }
    public void remove(SceneObject object){
        children.remove(object);
    }


    public static void printSceneTree(SceneObject object, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + object);

        if (object instanceof SceneGroup) {
            List<SceneObject> children = ((SceneGroup) object).getChildren();
            for (int i = 0; i < children.size() - 1; i++) {
                printSceneTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            if (children.size() > 0) {
                printSceneTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    public List<SceneObject> getChildren() {
        return children;
    }


    @Override
    public void draw() {
        for (SceneObject child : children) {
            child.draw();
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
