package gui.mvp.quiz.editor;

import gui.mvp.quiz.UndoRedoManager;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class EditorPresenter
{

    private Model model;

    private EditorView editorview;

    private UndoRedoManager manager;

    public EditorPresenter()
    {
        this.manager = new UndoRedoManager();
    }

    public EditorView getView()
    {
        editorview.initList();
        return editorview;
    }

    public void setModel(Model mo)
    {
        model = mo;
    }

    public void setView(EditorView ev)
    {
        editorview = ev;
    }

    // ------------- UndoRedo

    public void inputQuestion(String question)
    {
        String oldQuestion = model.getQuestion();

    }

    public void canUndo()
    {
        manager.canUndo();
    }

    public void canRedo()
    {
        manager.redo();
    }

    public void undo()
    {
        System.out.println("undo ausgefuehrt");
        manager.undo();
    }

    public void redo()
    {
        System.out.println("redo ausgefuehrt");
        manager.redo();
    }

    // ------------- Question add, change, show, delete

    public void addQuestion(Question q)
    {
        model.addQuestion(q);
    }

    public void changeQuestion(Question old, Question n)
    {
        model.replaceQuestion(old, n);
    }

    public void deleteQuestion(Question q)
    {
        if (q == null)
        {
            editorview.showSelectedDialog();
        }
        else
        {
            editorview.showDeleteDialog();
        }
    }

    public void deleteQuestion(Question q, boolean delete)
    {
        if (delete)
        {
            model.deleteQuestion(q);
            editorview.initList();
        }

    }

    public void showEdit(Question q)
    {
        if (q != null)
        {
            EditView ev = new EditView(true, this);
            ev.init(q);
            ev.showAndWait();
            editorview.initList();
        }
        else
        {
            editorview.showSelectedDialog();
        }
    }

    public void showNew()
    {
        EditView ev = new EditView(false, this);
        ev.showAndWait();
        editorview.initList();
    }

    public Question[] getQuestions()
    {
        return model.getQuestionList().toArray(new Question[model.getQuestionList().size()]);

    }
}
