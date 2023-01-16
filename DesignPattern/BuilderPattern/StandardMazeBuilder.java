public class StandardMazeBuilder extends MazeBuilder{
    public enum Direction{
        North, South, East, West
    }

    private static Maze _currentMaze;

    public StandardMazeBuilder(){
        _currentMaze= null;
    }

    public static void BuildMaze() {
        Maze Maze;
        _currentMaze = new Maze();
    }

    public static Maze GetMaze(){
        return _currentMaze;
    }

    public static void BuildRoom(int room){
//        if(!_currentMaze->Room(room))
    }

    public static void BuildDoor(int RoomFrom, int RoomTo){}

    private Direction CommonWall(Room room1, Room room2){
        return Direction.North;
    }



}
