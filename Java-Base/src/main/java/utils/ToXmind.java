package utils;

/**
 * @author weimenghua
 * @time 2023-05-30 16:39
 * @description
 */

import org.xmind.core.*;
import java.io.IOException;
import java.util.ArrayList;

public class ToXmind {

    public static void main(String[] args) throws CoreException, IOException {
        String root = "演示脑图";
        String xmindPath = "./demo.xmind";
        createXmind(root, xmindPath);
    }


    public static void createXmind(String root, String path) throws CoreException, IOException {

        // 创建思维导图的工作空间
        IWorkbookBuilder workbookBuilder = Core.getWorkbookBuilder();
        IWorkbook workbook = workbookBuilder.createWorkbook();

        // 获得默认sheet
        ISheet primarySheet = workbook.getPrimarySheet();

        // 获得根主题
        ITopic rootTopic = primarySheet.getRootTopic();
        // 设置根主题的标题
        rootTopic.setTitleText(root);
        //正确的逻辑图 org.xmind.ui.logic.right
        rootTopic.setStructureClass("org.xmind.ui.logic.right");
        //创建所有节点的集合
        ArrayList<ITopic> chapterTopics = new ArrayList<>();
        //创建一级主题
        ITopic topic = workbook.createTopic();
        //给主题设置标题名称
        topic.setTitleText("第一个，一级节点");
        chapterTopics.add(topic);


        //创建一级主题第二个
        ITopic topic1 = workbook.createTopic();
        //给主题设置标题名称
        topic1.setTitleText("第二个，一级节点");
        //父主题需要直接加到结合里面，后面会一起和跟节点关联
        chapterTopics.add(topic1);

        //设置二级主题，关联到第二个一级节点
        ITopic topicSecond = workbook.createTopic();
        topicSecond.setTitleText("二级节点");
        /*二级节点是一级节点的子节点，所以可以直接进行关联（这里因为父节点刚加进去，所以坐标应该是size-1），无需add
        节点提供三种关联关系：
           String ATTACHED = "attached";
           String DETACHED = "detached";
           String SUMMARY = "summary";
         */
        chapterTopics.get(chapterTopics.size() - 1).add(topicSecond, ITopic.ATTACHED);


        //给二级节点设置笔记
        IPlainNotesContent plainContent = (IPlainNotesContent) workbook.createNotesContent(INotes.PLAIN);
        String content = "我是笔记内容";
        plainContent.setTextContent(content);
        INotes notes = topicSecond.getNotes();
        notes.setContent(INotes.PLAIN, plainContent);
        //把所有一级节点都加到根节点上
        chapterTopics.forEach(it -> rootTopic.add(it, ITopic.ATTACHED));

        workbook.save(path);
    }

}

