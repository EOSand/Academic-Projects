package periodic_table;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PeriodicTable extends Application {
  public void start(Stage primaryStage) throws Exception {
    StackPane root = new StackPane();
    GridPane grid = new GridPane();
    grid.setHgap(10.0D);
    grid.setVgap(10.0D);
    grid.setAlignment(Pos.CENTER);
    root.getChildren().add(grid);
    ArrayList<StackPane> elementList = new ArrayList<>();
    byte b;
    int j;
    Elements.Element[] arrayOfElement;
    for (j = (arrayOfElement = Elements.Element.values()).length, b = 0; b < j; ) {
      Elements.Element element = arrayOfElement[b];
      setElement(element, grid, elementList);
      b++;
    } 
    Scene scene = new Scene(root, 1280.0D, 720.0D);
    for (int i = 0; i < elementList.size(); i++) {
      StackPane stack = elementList.get(i);
      addListeners(root, stack, grid, scene);
    } 
    primaryStage.setTitle("Periodic Table of Elements");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  private void setElement(Elements.Element element, GridPane grid, ArrayList<StackPane> elementList) {
    Color color;
    StackPane stack = new StackPane();
    Rectangle rect = new Rectangle(60.0D, 60.0D);
    switch (element.getCategory()) {
      case null:
        color = Color.PALEVIOLETRED;
        break;
      case ALKALI:
        color = Color.CRIMSON;
        break;
      case ALKALINE_EARTH:
        color = Color.CORAL;
        break;
      case LANTHANIDE:
        color = Color.PLUM;
        break;
      case METALLOID:
        color = Color.BURLYWOOD;
        break;
      case NOBLE_GAS:
        color = Color.AQUA;
        break;
      case POST_TRANSITION:
        color = Color.LIGHTSLATEGRAY;
        break;
      case REACTIVE_NONMETAL:
        color = Color.GOLD;
        break;
      case TRANSITION:
        color = Color.DARKSALMON;
        break;
      default:
        color = Color.LIGHTGRAY;
        break;
    } 
    rect.setFill(color);
    rect.setStroke(Color.WHITE);
    Text text = new Text(String.valueOf(element.getAtomicNumber()) + "\n" + element.name());
    text.setFill(Color.WHITE);
    stack.getChildren().addAll(new Node[] { rect, text });
    grid.add(stack, element.getGroup() - 1, element.getPeriod() - 1);
    elementList.add(stack);
  }
  
  private void addListeners(final StackPane root, final StackPane stack, final GridPane grid, final Scene scene) {
    stack.setOnMouseEntered(new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            scene.setCursor(Cursor.HAND);
          }
        });
    stack.setOnMouseExited(new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            scene.setCursor(Cursor.DEFAULT);
          }
        });
    stack.setOnMouseReleased(new EventHandler<MouseEvent>() {
          public void handle(MouseEvent e) {
            try {
              PeriodicTable.this.openElement(root, stack, grid, scene);
            } catch (MalformedURLException e1) {
              e1.printStackTrace();
            } 
          }
        });
  }
  
  private void openElement(StackPane root, StackPane stack, GridPane grid, Scene scene) throws MalformedURLException {
    Paint fill = ((Rectangle)stack.getChildren().get(0)).getFill();
    String s = ((Text)stack.getChildren().get(1)).getText();
    String elemSymbol = s.substring(s.indexOf("\n") + 1);
    Elements.Element element = Elements.Element.valueOf(elemSymbol);
    StackPane window = new StackPane();
    Rectangle windowRect = new Rectangle(750.0D, 400.0D);
    windowRect.setFill(Color.WHITE);
    windowRect.setStroke(Color.SLATEGRAY);
    windowRect.setStrokeWidth(3.0D);
    Rectangle cell = new Rectangle(300.0D, 300.0D);
    cell.setFill(fill);
    cell.setTranslateX(
        -((windowRect.getWidth() - cell.getWidth()) / 2.0D - (windowRect.getHeight() - cell.getHeight()) / 2.0D));
    GridPane elementGrid = setWindowInfo(fill, element, grid, window, windowRect, cell, scene);
    GridPane cellGrid = setCellInfo(element, grid, windowRect, cell, scene);
    window.getChildren().addAll(new Node[] { windowRect, cell, cellGrid, elementGrid });
    window.setTranslateY(scene.getHeight());
    transitionIn(window, grid, scene);
    root.getChildren().addAll(new Node[] { window });
  }
  
  private static void openWebpage(String url) {
    try {
      Desktop.getDesktop().browse((new URL(url)).toURI());
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void transitionIn(StackPane window, GridPane grid, Scene scene) {
    grid.setEffect(new GaussianBlur());
    Line pathIn = new Line(scene.getWidth() / 2.0D, 2.0D * scene.getHeight(), scene.getWidth() / 2.0D, 
        scene.getHeight() / 2.0D);
    PathTransition transition = new PathTransition();
    transition.setNode(window);
    transition.setDuration(Duration.seconds(0.5D));
    transition.setPath(pathIn);
    transition.play();
  }
  
  private void transitionOut(StackPane window, GridPane grid, Scene scene) {
    grid.setEffect(null);
    Line pathOut = new Line(scene.getWidth() / 2.0D, scene.getHeight() / 2.0D, scene.getWidth() / 2.0D, 
        2.0D * scene.getHeight());
    PathTransition transition = new PathTransition();
    transition.setNode(window);
    transition.setDuration(Duration.seconds(0.5D));
    transition.setPath(pathOut);
    transition.play();
  }
  
  private GridPane setWindowInfo(Paint fill, Elements.Element element, final GridPane grid, final StackPane window, Rectangle windowRect, Rectangle cell, final Scene scene) {
    GridPane elementGrid = new GridPane();
    int atomicNum = element.getAtomicNumber();
    String fullName = String.valueOf(element.getFullName());
    double atomicMass = element.getAtomicMass();
    double meltingPoint = element.getMeltingPoint();
    double boilingPoint = element.getBoilingPoint();
    double density = element.getDensity();
    String phase = String.valueOf(element.getPhase()).toLowerCase();
    String category = String.valueOf(element.getCategory()).toLowerCase();
    boolean isRadioactive = element.isRadioactive();
    final String elementUrl = String.format("https://en.wikipedia.org/wiki/%s", new Object[] { String.valueOf(fullName) });
    Text txtMeltingPoint = formatMeltingPoint(meltingPoint);
    Text txtBoilingPoint = formatBoilingPoint(boilingPoint);
    Text txtDensity = formatDensity(density);
    Text txtPhase = formatPhase(phase);
    Text txtCategory = formatCategory(category, fill);
    Text txtIsRadioactive = formatIsRadioactive(isRadioactive);
    ArrayList<Text> textList = new ArrayList<>();
    textList.add(new Text("Atomic Number:\t"));
    textList.add(new Text("Atomic Mass:"));
    textList.add(new Text("Melting Point:"));
    textList.add(new Text("Boiling Point:"));
    textList.add(new Text("Density:"));
    textList.add(new Text("Phase:"));
    textList.add(new Text("Category:"));
    textList.add(new Text("Radioactive:"));
    textList.add(new Text(String.format("%d", new Object[] { Integer.valueOf(atomicNum) })));
    textList.add(new Text(String.format("%.2f", new Object[] { Double.valueOf(atomicMass) })));
    textList.add(txtMeltingPoint);
    textList.add(txtBoilingPoint);
    textList.add(txtDensity);
    textList.add(txtPhase);
    textList.add(txtCategory);
    textList.add(txtIsRadioactive);
    textList.forEach(e -> e.setFont(Font.font("", 20.0D)));
    int i;
    for (i = 0; i < textList.size() / 2; i++)
      elementGrid.add(textList.get(i), 0, i); 
    for (i = textList.size() / 2; i < textList.size(); i++)
      elementGrid.add(textList.get(i), 1, i - textList.size() / 2); 
    elementGrid.setTranslateX(scene.getWidth() / 2.0D + (windowRect.getWidth() - 2.0D * cell.getWidth()) / 6.0D);
    elementGrid.setTranslateY((scene.getHeight() - cell.getHeight()) / 2.0D);
    elementGrid.setVgap(grid.getVgap());
    Button back = new Button("Back to Table");
    Button openWiki = new Button("Open Wikipedia Page");
    back.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent e) {
            PeriodicTable.this.transitionOut(window, grid, scene);
          }
        });
    openWiki.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent e) {
            PeriodicTable.openWebpage(elementUrl);
          }
        });
    elementGrid.add(back, 0, 9);
    elementGrid.add(openWiki, 1, 9);
    return elementGrid;
  }
  
  private GridPane setCellInfo(Elements.Element element, GridPane grid, Rectangle windowRect, Rectangle cell, Scene scene) {
    GridPane cellGrid = new GridPane();
    ArrayList<Text> cellTextList = new ArrayList<>();
    cellTextList.add(new Text(String.valueOf(element.getAtomicNumber())));
    cellTextList.add(new Text(String.valueOf(element.name())));
    cellTextList.add(new Text(""));
    cellTextList.add(new Text(String.valueOf(element.getFullName())));
    cellTextList.add(new Text(String.valueOf(element.getAtomicMass())));
    ((Text)cellTextList.get(0)).setFont(Font.font("", 35.0D));
    ((Text)cellTextList.get(1)).setFont(Font.font("SF Pro Display", FontWeight.BOLD, 100.0D));
    ((Text)cellTextList.get(2)).setFont(Font.font("", 35.0D));
    ((Text)cellTextList.get(3)).setFont(Font.font("", 35.0D));
    ((Text)cellTextList.get(4)).setFont(Font.font("", 35.0D));
    for (int i = 0; i < cellTextList.size(); i++)
      cellGrid.add(cellTextList.get(i), 0, i); 
    cellGrid.setTranslateX((scene.getWidth() - windowRect.getWidth()) / 2.0D + (
        windowRect.getWidth() - 2.0D * cell.getWidth()) / 3.0D + grid.getHgap());
    cellGrid.setTranslateY((scene.getHeight() - windowRect.getHeight()) / 2.0D + (
        windowRect.getHeight() - cell.getHeight()) / 2.0D + grid.getHgap());
    return cellGrid;
  }
  
  private Text formatMeltingPoint(double meltingPoint) {
    if (meltingPoint == 0.0D) {
      Text text = new Text("unknown");
      text.setFill(Color.LIGHTGRAY);
      return text;
    } 
    Text txtMeltingPoint = new Text(String.format("%.2f K", new Object[] { Double.valueOf(meltingPoint) }));
    return txtMeltingPoint;
  }
  
  private Text formatBoilingPoint(double boilingPoint) {
    if (boilingPoint == 0.0D) {
      Text text = new Text("unknown");
      text.setFill(Color.LIGHTGRAY);
      return text;
    } 
    Text txtBoilingPoint = new Text(String.format("%.2f K", new Object[] { Double.valueOf(boilingPoint) }));
    return txtBoilingPoint;
  }
  
  private Text formatDensity(double density) {
    if (density == 0.0D) {
      Text text = new Text("unknown");
      text.setFill(Color.LIGHTGRAY);
      return text;
    } 
    Text txtDensity = new Text(String.format("%.2f g/L", new Object[] { Double.valueOf(density) }));
    return txtDensity;
  }
  
  private Text formatPhase(String phase) {
    Text txtPhase = new Text(phase);
    String str;
    switch ((str = phase).hashCode()) {
      case -1102567108:
        if (!str.equals("liquid"))
          break; 
        txtPhase.setFill(Color.MEDIUMBLUE);
        return txtPhase;
      case -284840886:
        if (!str.equals("unknown"));
        break;
      case 102105:
        if (!str.equals("gas"))
          break; 
        txtPhase.setFill(Color.LIGHTGREEN);
        break;
      case 109618859:
        if (!str.equals("solid"))
          break; 
        txtPhase.setFill(Color.DARKSLATEGRAY);
        return txtPhase;
    } 
    txtPhase.setFill(Color.LIGHTGRAY);
    return txtPhase;
  }
  
  private Text formatCategory(String category, Paint fill) {
    String str;
    switch ((str = category).hashCode()) {
      case -1895798352:
        if (!str.equals("lanthanide"))
          break; 
        txtCategory = new Text("lanthanide");
        txtCategory.setFill(fill);
        return txtCategory;
      case -1724158635:
        if (!str.equals("transition"))
          break; 
        txtCategory = new Text("transition metal");
        txtCategory.setFill(fill);
        return txtCategory;
      case -1656205805:
        if (!str.equals("actinide"))
          break; 
        txtCategory = new Text("actinide");
        txtCategory.setFill(fill);
        return txtCategory;
      case -1414915074:
        if (!str.equals("alkali"))
          break; 
        txtCategory = new Text("alkali metal");
        txtCategory.setFill(fill);
        return txtCategory;
      case -1164081580:
        if (!str.equals("post_transition"))
          break; 
        txtCategory = new Text("post-transition");
        txtCategory.setFill(fill);
        return txtCategory;
      case -1103872748:
        if (!str.equals("noble_gas"))
          break; 
        txtCategory = new Text("noble gas");
        txtCategory.setFill(fill);
        return txtCategory;
      case -1057516187:
        if (!str.equals("metalloid"))
          break; 
        txtCategory = new Text("metalloid");
        txtCategory.setFill(fill);
        return txtCategory;
      case -558538304:
        if (!str.equals("alkaline_earth"))
          break; 
        txtCategory = new Text("alkaline earth");
        txtCategory.setFill(fill);
        return txtCategory;
      case -426223904:
        if (!str.equals("reactive_nonmetal"))
          break; 
        txtCategory = new Text("nonmetal");
        txtCategory.setFill(fill);
        return txtCategory;
      case -284840886:
        if (!str.equals("unknown"));
        break;
    } 
    Text txtCategory = new Text("unknown");
    txtCategory.setFill(fill);
    return txtCategory;
  }
  
  private Text formatIsRadioactive(boolean isRadioactive) {
    Text txtIsRadioactive;
    if (isRadioactive) {
      txtIsRadioactive = new Text("yes");
      txtIsRadioactive.setFill(Color.LIMEGREEN);
    } else {
      txtIsRadioactive = new Text("no");
      txtIsRadioactive.setFill(Color.DARKRED);
    } 
    return txtIsRadioactive;
  }
  
  public static void main(String[] args) {
    Application.launch(args);
  }
}
