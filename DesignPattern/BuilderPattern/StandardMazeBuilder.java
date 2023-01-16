public class StandardMazeBuilder extends MazeBuilder{

    public static Room.Direction direction;

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
        if(_currentMaze.RoomNo(room)!= null){
            Room Room = new Room(room);
            _currentMaze.AddRoom(Room);

            Room.SetSide(direction.North, new Wall());
            Room.SetSide(direction.South, new Wall());
            Room.SetSide(direction.East, new Wall());
            Room.SetSide(direction.West, new Wall());
        }
    }

    public static Room.Direction CommonWall(Room room1, Room room2){
        return Room.Direction.North;
    }
    public static void BuildDoor(int RoomFrom, int RoomTo){
       Room r1= _currentMaze.RoomNo(RoomFrom);
       Room r2= _currentMaze.RoomNo(RoomTo);
       Door door= new Door(r1, r2);

       r1.SetSide(CommonWall(r1, r2), door);
       r2.SetSide(CommonWall(r2, r1), door);
    }


}
