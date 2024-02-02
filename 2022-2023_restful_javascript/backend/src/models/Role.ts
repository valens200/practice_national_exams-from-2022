import { UUID } from "mongodb";
import { DataTypes, Model } from "sequelize";
const sequelize = require("../database/squalizer");

class Role extends Model {
  private id!: UUID;
  roleName!: string;
}

export default Role.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    roleName: {
      type: DataTypes.STRING,
    },
  },
  {
    sequelize: sequelize,
    modelName: "Role",
    tableName: "roles",
  }
);
