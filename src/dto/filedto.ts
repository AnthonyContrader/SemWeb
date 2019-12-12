import { UserDTO } from './userdto';
import { TopicDTO } from './topicdto';

export class FileDTO {

    id: number;

    path: string;

    description: string;

    type: string;

    userDTO: UserDTO;

    topicDTO: TopicDTO;
}