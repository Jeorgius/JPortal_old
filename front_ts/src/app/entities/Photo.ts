import {photoList} from "../content/interfaces/displayContent";

export class Photo implements photoList{
  public id :number;

  constructor(
    public picHTML :string,
    public altText :string
  ){}
}
