package com.javarush.test.level23.lesson13.big01;


import java.awt.event.KeyEvent;

/**
 * Основной класс программы.
 */
public class Room
{
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Room game;

    public Room(int width, int height, Snake snake)
    {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public Snake getSnake()
    {
        return snake;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run()
    {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive())
        {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents())
            {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Выводим на экран текущее состояние игры
     */

    public void print()
    {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] gameMatrix = new int[height][width];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (i == mouse.getX() && j == mouse.getY())
                {
                    gameMatrix[i][j] = 3;
                }
                else if (i == snake.getSections().get(0).getX() && j == snake.getSections().get(0).getY())
                {
                    gameMatrix[i][j] = 2;
                }
                 else for (int s = 1; s < snake.getSections().size(); s++)
                {
                    if (i == snake.getSections().get(s).getX() && j == snake.getSections().get(s).getY())
                    {
                        gameMatrix[i][j] = 1;
                    }
                    else gameMatrix[i][j] = 0;//пустое поле
                }

            }
        }
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (gameMatrix[i][j] == 0)
                    System.out.print(".");
                if (gameMatrix[i][j] == 1)
                    System.out.print("x");
                if (gameMatrix[i][j] == 2)
                    System.out.print("X");
                if (gameMatrix[i][j] == 3)
                    System.out.print("m");
            }
            System.out.println();
        }

    }

    /**
     * Метод вызывается, когда мышь съели
     */
    public void eatMouse()
    {
        createMouse();
    }

    /**
     * Создает новую мышь
     */
    public void createMouse()
    {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }


    public static void main(String[] args)
    {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }


    /**
     * Прогрмма делает паузу, длинна которой зависит от длинны змеи.
     */

    public void sleep()
    {
        int time;
        if (snake.getSections().size() < 15)
        {
            time = (int) (4700 / 9 - 200 * snake.getSections().size() / 9);
        } else
            time = 200;
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {

        }
    }
}
