public class MazeGame {

    public Maze MazeGame(MazeBuilder builder){
        builder.buildMaze();
        builder.BuildRoom(1);
        builder.BuildRoom(2);
        builder.BuildDoor(1,2);

        return builder.GetMaze();
    }
}
