export interface newsList {
    newsTitle: string,
    picHTML: string,
    newsText: string
}
export interface photoList {
  picHTML: string,
  altText: string
}
export interface regUser {
  nick: string,
  pw: string,
  email: string,

  name: string,
  surname: string,
  city: string
}

export interface userList {
  id: number,
  nickname: string,
  name: string,
  surname: string,
  picHTML: string
}
export interface musicList {
  title: string;
  length: string;
  description: string;
}

export class UserReg {
  constructor (
    public nick: string,
    public pw: string,
    public email: string,
    public name: string,
    public surname: string,
    public city: string,
    public sub: boolean
  ) {}
}
