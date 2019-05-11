/**
 * Base class for Creators
 * Introduced as a layer for Sibling-Parent-Sibling component interaction
 * Basicly, from BlockAdder-Creator-BlockFactory
 */
export class Creator {
  public blockType :string = "";

  receiveBlockType(blockType :string){
    this.blockType=blockType;
  }

}
