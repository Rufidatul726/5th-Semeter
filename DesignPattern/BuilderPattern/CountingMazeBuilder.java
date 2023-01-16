public class CountingMazeBuilder extends MazeBuilder{
    private static int _doors;
    private static int _rooms;
    public CountingMazeBuilder() {
        _doors = 0;
        _rooms = 0;
    }

    public static void BuildMaze() {
        _rooms++;
    }

    public static void BuildRoom(int room) {
        _doors++;
    }

    public static void BuildDoor(int roomFrom, int roomTo) {
    }

    public static void AddWall(int room, Room.Direction direction) {
    }

    public void GetCounts(int doors, int rooms, int walls) {
        rooms = _rooms;
        doors = _doors;

    }

}
