import { UserDTO } from './userdto';
import { TopicDTO } from './topicdto'; 

export class ResearchDTO {

    id: number;

    date: Date;

    userId: UserDTO;

    topicId: TopicDTO;

}