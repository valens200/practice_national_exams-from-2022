export type CreateUser = {
  firstName: string;
  lastName: string;
  userName: string;
  email: string;
  password: string;
};

export type LoginDTO = {
  email: string;
  password: string;
};
